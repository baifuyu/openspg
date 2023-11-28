/*
 * Copyright 2023 Ant Group CO., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 */

package com.antgroup.openspg.builder.core.runtime.impl;

import com.antgroup.openspg.builder.core.logical.LogicalPlan;
import com.antgroup.openspg.builder.core.physical.BasePhysicalNode;
import com.antgroup.openspg.builder.core.physical.BuilderRecord;
import com.antgroup.openspg.builder.core.physical.PhysicalPlan;
import com.antgroup.openspg.builder.core.physical.process.BaseProcessor;
import com.antgroup.openspg.builder.core.physical.sink.BaseSinkWriter;
import com.antgroup.openspg.builder.core.physical.source.BaseSourceReader;
import com.antgroup.openspg.builder.core.runtime.BuilderRecordException;
import com.antgroup.openspg.builder.core.runtime.PipelineExecutor;
import com.antgroup.openspg.builder.core.runtime.RecordCollector;
import com.antgroup.openspg.builder.core.runtime.RuntimeContext;
import com.antgroup.openspg.builder.model.pipeline.Pipeline;
import com.antgroup.openspg.builder.model.record.BaseRecord;
import com.antgroup.openspg.builder.model.record.EventRecord;
import com.antgroup.openspg.common.util.thread.ThreadUtils;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

@Slf4j
public class DefaultPipelineExecutor implements PipelineExecutor {

  public DefaultPipelineExecutor() {}

  @Override
  public PhysicalPlan plan(Pipeline pipeline) {
    // Convert the user-configured pipeline into a logical execution plan.
    LogicalPlan logicalPlan = LogicalPlan.parse(pipeline);
    // Translate the logical execution plan into a physical execution plan.
    return PhysicalPlan.plan(logicalPlan);
  }

  @Override
  public void execute(PhysicalPlan plan, RuntimeContext context) {
    for (BasePhysicalNode node : plan.nodes()) {
      try {
        node.init(context);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    Meter totalMeter = context.getMetrics().getTotalCnt();
    Counter errorCnt = context.getMetrics().getErrorCnt();
    RecordCollector recordCollector = context.getRecordCollector();
    for (BaseSourceReader<?> sourceReader : plan.sourceReaders()) {
      List<BaseRecord> records = Collections.unmodifiableList(sourceReader.read());

      while (CollectionUtils.isNotEmpty(records)) {
        totalMeter.mark(records.size());

        // start processing each record
        for (BaseRecord record : records) {
          // FIXME
          AtomicLong preSinkNumber = new AtomicLong(0);
          while (true) {
            AtomicLong curSinkNumber = new AtomicLong(0);
            AtomicBoolean anyEventRecord = new AtomicBoolean(false);
            List<BaseRecord> inputRecords = new ArrayList<>(1);
            inputRecords.add(record);

            for (BasePhysicalNode successor : plan.successors(sourceReader)) {
              try {
                fireDag(successor, inputRecords, plan, curSinkNumber, anyEventRecord);
              } catch (BuilderRecordException e) {
                // if an error occurs during record processing, collect and count here
                errorCnt.inc();
                recordCollector.collectRecord((BuilderRecord) record, e);
                log.warn("process record(id={}) error", ((BuilderRecord) record).getRecordId(), e);
              }
            }

            if (curSinkNumber.get() <= preSinkNumber.get()
                || !context.isEnableLeadTo()
                || !anyEventRecord.get()) {
              break;
            }
            preSinkNumber.set(curSinkNumber.get());
          }
        }
        records = Collections.unmodifiableList(sourceReader.read());
      }
    }
  }

  private void fireDag(
      BasePhysicalNode physicalNode,
      List<BaseRecord> inputRecords,
      PhysicalPlan plan,
      AtomicLong curSinkNumber,
      AtomicBoolean anyEventRecord) {
    if (CollectionUtils.isEmpty(inputRecords)) {
      return;
    }
    List<BaseRecord> outputRecords = null;
    if (physicalNode instanceof BaseProcessor) {
      BaseProcessor<?> processor = (BaseProcessor<?>) physicalNode;
      try {
        outputRecords = processor.process(inputRecords);
      } catch (Exception e) {
        throw new BuilderRecordException(processor, e, e.getMessage());
      }

      List<BasePhysicalNode> successors =
          plan.successors(processor).stream().sorted().collect(Collectors.toList());
      for (int i = 0; i < successors.size(); i++) {
        BasePhysicalNode successor = successors.get(i);
        if (successors.size() > 1 && i == successors.size() - 1) {
          ThreadUtils.sleep(5000);
        }
        fireDag(successor, outputRecords, plan, curSinkNumber, anyEventRecord);
      }
    } else if (physicalNode instanceof BaseSinkWriter) {
      curSinkNumber.addAndGet(inputRecords.size());
      if (inputRecords.stream().anyMatch(x -> x instanceof EventRecord)) {
        anyEventRecord.set(true);
      }
      BaseSinkWriter<?> sinkWriter = (BaseSinkWriter<?>) physicalNode;
      sinkWriter.write(inputRecords);
    }
  }
}

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

package com.antgroup.openspg.core.spgbuilder.engine.physical.source;

import com.antgroup.openspg.common.util.StringUtils;
import com.antgroup.openspg.core.spgbuilder.engine.physical.BuilderRecord;
import com.antgroup.openspg.core.spgbuilder.engine.runtime.RuntimeContext;
import com.antgroup.openspg.core.spgbuilder.model.pipeline.config.CsvSourceNodeConfig;
import com.antgroup.openspg.core.spgbuilder.model.record.BaseRecord;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvFileSourceReader extends BaseSourceReader<CsvSourceNodeConfig> {

  private Queue<BaseRecord> queue;
  private CSVReader csvReader;
  private Iterator<String[]> lines;
  private AtomicLong lineNumber;

  public CsvFileSourceReader(String id, String name, CsvSourceNodeConfig config) {
    super(id, name, config);
  }

  @Override
  public void doInit(RuntimeContext context) throws Exception {
    queue = new ArrayBlockingQueue<>(context.getBatchSize() * context.getParallelism());
    csvReader =
        new CSVReaderBuilder(new FileReader(config.getUrl()))
            .withSkipLines(config.getStartRow() - 1)
            .build();
    lineNumber = new AtomicLong(config.getStartRow() - 1);
    lines = csvReader.iterator();
  }

  @Override
  public void close() throws Exception {
    if (csvReader != null) {
      csvReader.close();
    }
  }

  @Override
  public List<BaseRecord> read() {
    putQueue();
    List<BaseRecord> results = new ArrayList<>(context.getBatchSize());
    for (int i = 0; i < context.getBatchSize(); i++) {
      BaseRecord poll = queue.poll();
      if (poll == null) {
        putQueue();
        poll = queue.poll();
      }

      // 如果拿到的是空，则说明队列中确实没有了，则breaks
      if (poll == null) {
        break;
      }
      results.add(poll);
    }
    return results;
  }

  private void putQueue() {
    if (queue.size() < context.getBatchSize()) {
      synchronized (this) {
        if (queue.size() < context.getBatchSize()) {
          int curLen = queue.size();
          int batchSize = context.getBatchSize() * context.getParallelism();
          while (curLen < batchSize && lines.hasNext()) {
            String[] next = lines.next();
            lineNumber.addAndGet(1);
            if (next == null || (next.length == 1 && StringUtils.isBlank(next[0]))) {
              continue;
            }
            queue.add(parse(next));
            curLen += 1;
          }
        }
      }
    }
  }

  private BuilderRecord parse(String[] fields) {
    Map<String, String> props = new HashMap<>(config.getColumns().size());
    for (int i = 0; i < config.getColumns().size(); i++) {
      String column = config.getColumns().get(i);
      if (i >= fields.length) {
        props.put(column, null);
      } else {
        props.put(column, fields[i]);
      }
    }
    return new BuilderRecord("line" + lineNumber.get(), props);
  }
}

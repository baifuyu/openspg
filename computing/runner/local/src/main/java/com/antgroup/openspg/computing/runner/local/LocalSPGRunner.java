package com.antgroup.openspg.computing.runner.local;

import com.antgroup.openspg.computing.core.Runner;
import com.antgroup.openspg.computing.core.catalog.types.StructField;
import com.antgroup.openspg.computing.core.catalog.types.StructType;
import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Row;
import com.antgroup.openspg.computing.core.rdk.struct.RowImpl;
import com.antgroup.openspg.computing.core.rdk.struct.SubGraph;
import com.google.common.collect.Lists;

public class LocalSPGRunner extends Runner {

  @Override
  public RDK<Row> createDataFrame(String uri) {
    StructType structType =
        new StructType(
            Lists.newArrayList(
                new StructField("id", null),
                new StructField("name", null),
                new StructField("desc", null)));
    return new LocalRDK<>(
        Lists.newArrayList(
            new RowImpl(Lists.newArrayList("1", "person1", "person1"), structType),
            new RowImpl(Lists.newArrayList("2", "person2", "person2"), structType)));
  }

  @Override
  public void saveDataFrame() {}

  @Override
  public RDK<SubGraph> createGraphFrame() {
    return null;
  }

  @Override
  public void saveGraphFrame() {}
}

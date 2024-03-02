package com.antgroup.openspg.computing.runner.local.rdk;

import com.antgroup.openspg.computing.core.SPGRunner;
import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Row;
import com.antgroup.openspg.computing.core.rdk.struct.SubGraph;

public class LocalSPGRunner extends SPGRunner {

  @Override
  public RDK<Row> createDataFrame() {
    return null;
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

package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Row;
import com.antgroup.openspg.computing.core.rdk.struct.SubGraph;

public abstract class SPGRunner {

  public abstract RDK<Row> createDataFrame();

  public abstract void saveDataFrame();

  public abstract RDK<SubGraph> createGraphFrame();

  public abstract void saveGraphFrame();
}

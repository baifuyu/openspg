package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Row;
import com.antgroup.openspg.computing.core.rdk.struct.SubGraph;
import lombok.Setter;

public abstract class Runner {

  @Setter protected SPGSession spgSession;

  public abstract RDK<Row> createDataFrame(String uri);

  public abstract void saveDataFrame();

  public abstract RDK<SubGraph> createGraphFrame();

  public abstract void saveGraphFrame();
}

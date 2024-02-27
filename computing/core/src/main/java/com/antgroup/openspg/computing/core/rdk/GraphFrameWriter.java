package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.SinkWriter;

public class GraphFrameWriter<T> {

  private final GraphFrame gf;

  public GraphFrameWriter(GraphFrame gf) {
    this.gf = gf;
  }

  public void csv(String path) {
    QueryExecution qe = new QueryExecution(gf.queryExecution.getSpgSession(), new SinkWriter());
    qe.execute();
  }
}

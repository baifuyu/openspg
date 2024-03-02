package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.SinkWriter;

public class GraphFrameWriter {

  private final GraphFrame gf;

  public GraphFrameWriter(GraphFrame gf) {
    this.gf = gf;
  }

  public void csv(String path) {
    QueryExecution qe =
        new QueryExecution(gf.qe.getSpgSession(), new SinkWriter(gf.qe.getLogicalPlan()));
    qe.execute();
  }

  public void reason(String path) {
  }

  public class PostProcessor {

    public GraphFrameReasoner reason() {
      return new GraphFrameReasoner(gf);
    }
  }
}

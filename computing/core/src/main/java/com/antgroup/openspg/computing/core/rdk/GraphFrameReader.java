package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.GraphFrameSourceReader;

public class GraphFrameReader {

  private final SPGSession spgSession;

  public GraphFrameReader(SPGSession spgSession) {
    this.spgSession = spgSession;
  }

  public GraphFrame graph(String uri) {
    return new GraphFrame(new QueryExecution(spgSession, new GraphFrameSourceReader(uri)));
  }
}

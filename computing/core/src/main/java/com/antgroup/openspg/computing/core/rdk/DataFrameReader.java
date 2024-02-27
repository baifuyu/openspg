package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.SourceReader;

public class DataFrameReader {

  private final SPGSession spgSession;

  public DataFrameReader(SPGSession spgSession) {
    this.spgSession = spgSession;
  }

  public DataFrame csv(String path) {
    return new DataFrame(new QueryExecution(spgSession, new SourceReader(path)));
  }
}

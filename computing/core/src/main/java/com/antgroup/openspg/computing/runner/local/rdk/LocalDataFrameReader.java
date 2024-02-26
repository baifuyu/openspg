package com.antgroup.openspg.computing.runner.local.rdk;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.rdk.DataFrame;
import com.antgroup.openspg.computing.core.rdk.DataFrameReader;

public class LocalDataFrameReader extends DataFrameReader {

  private final SPGSession session;

  public LocalDataFrameReader(SPGSession session) {
    this.session = session;
  }

  @Override
  public DataFrame csv(String path) {
    return null;
  }
}

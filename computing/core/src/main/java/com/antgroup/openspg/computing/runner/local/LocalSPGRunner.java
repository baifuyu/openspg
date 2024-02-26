package com.antgroup.openspg.computing.runner.local;

import com.antgroup.openspg.computing.core.SPGRunner;
import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.rdk.DataFrameReader;
import com.antgroup.openspg.computing.runner.local.rdk.LocalDataFrameReader;

public class LocalSPGRunner extends SPGRunner {

  @Override
  public DataFrameReader read(SPGSession session) {
    return new LocalDataFrameReader(session);
  }
}

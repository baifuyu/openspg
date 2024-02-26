package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.rdk.DataFrameReader;

public abstract class SPGRunner {

  public abstract DataFrameReader read(SPGSession session);
}

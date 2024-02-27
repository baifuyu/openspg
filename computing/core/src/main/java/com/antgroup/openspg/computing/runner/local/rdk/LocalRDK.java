package com.antgroup.openspg.computing.runner.local.rdk;

import com.antgroup.openspg.computing.core.conf.SaveConf;
import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Row;
import java.util.function.Function;

public class LocalRDK<T> extends RDK<T> {

  @Override
  public <U> RDK<U> map(Function<T, U> f) {
    return null;
  }

  @Override
  public RDK<T> filter(Function<Row, Boolean> f) {
    return null;
  }

  @Override
  public void save(SaveConf conf) {}
}

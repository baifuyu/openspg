package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.conf.SaveConf;
import java.io.Serializable;
import java.util.function.Function;

public abstract class RDK<T> implements Serializable {

  public abstract <U> RDK<U> map(Function<T, U> f);

  public abstract RDK<T> filter(Function<Row, Boolean> f);

  public abstract void save(SaveConf conf);
}

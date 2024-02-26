package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.plans.QueryExecution;
import java.io.Serializable;
import java.util.function.Function;

public abstract class Dataset<T extends Dataset<T, X>, X> implements Serializable {

  protected final QueryExecution queryExecution;

  public Dataset(QueryExecution queryExecution) {
    this.queryExecution = queryExecution;
  }

  public abstract T map(Function<X, X> func);

  public abstract T filter(Function<X, Boolean> func);
}

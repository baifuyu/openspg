package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.plans.QueryExecution;
import java.io.Serializable;
import java.util.function.Function;
import lombok.Getter;

@Getter
public abstract class Dataset<T extends Dataset<T, X>, X> implements Serializable {

  protected final QueryExecution qe;

  public Dataset(QueryExecution qe) {
    this.qe = qe;
  }

  public abstract T map(Function<X, X> func);

  public abstract T filter(Function<X, Boolean> func);
}

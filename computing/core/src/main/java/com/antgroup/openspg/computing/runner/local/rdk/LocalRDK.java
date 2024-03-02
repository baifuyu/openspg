package com.antgroup.openspg.computing.runner.local.rdk;

import com.antgroup.openspg.computing.core.rdk.RDK;
import java.util.Iterator;
import java.util.function.Function;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LocalRDK<T> extends RDK<T> {

  private final Iterator<T> iterator;

  @Override
  public <U> RDK<U> map(Function<T, U> f) {
    return null;
  }

  @Override
  public RDK<T> filter(Function<T, Boolean> f) {
    return null;
  }
}

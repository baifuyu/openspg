package com.antgroup.openspg.computing.runner.local;

import com.antgroup.openspg.computing.core.rdk.RDK;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LocalRDK<T> extends RDK<T> {

  private final List<T> iter;

  @Override
  public <U> RDK<U> map(Function<T, U> f) {
    List<U> newIter = iter.stream().map(f).collect(Collectors.toList());
    return new LocalRDK<>(newIter);
  }

  @Override
  public RDK<T> filter(Function<T, Boolean> f) {
    List<T> newIter = iter.stream().filter(f::apply).collect(Collectors.toList());
    return new LocalRDK<>(newIter);
  }
}

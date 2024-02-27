package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.conf.PatternConf;
import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.MapElements;
import com.antgroup.openspg.computing.core.plans.logical.TypedFilter;
import java.util.function.Function;

public class GraphFrame extends Dataset<GraphFrame, SubGraph> {

  public GraphFrame(QueryExecution queryExecution) {
    super(queryExecution);
  }

  /** 在进行这个之前，就不是iter形式了，就应该全部在内存了 */
  public GraphFrame patternMatch(PatternConf conf) {
    return null;
  }

  @Override
  public GraphFrame map(Function<SubGraph, SubGraph> func) {
    return new GraphFrame(
        new QueryExecution(queryExecution.getSpgSession(), new MapElements(func)));
  }

  @Override
  public GraphFrame filter(Function<SubGraph, Boolean> func) {
    return new GraphFrame(
        new QueryExecution(queryExecution.getSpgSession(), new TypedFilter(func)));
  }

  public GraphFrameWriter<SubGraph> write() {
    return new GraphFrameWriter<>(this);
  }
}

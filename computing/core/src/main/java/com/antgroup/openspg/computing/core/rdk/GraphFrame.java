package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.conf.PatternConf;
import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.Filter;
import com.antgroup.openspg.computing.core.plans.logical.Mapper;
import com.antgroup.openspg.computing.core.rdk.struct.SubGraph;
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
        new QueryExecution(qe.getSpgSession(), new Mapper(qe.getLogicalPlan(), func)));
  }

  @Override
  public GraphFrame filter(Function<SubGraph, Boolean> func) {
    return new GraphFrame(
        new QueryExecution(qe.getSpgSession(), new Filter(qe.getLogicalPlan(), func)));
  }

  public GraphFrameWriter write() {
    return new GraphFrameWriter(this);
  }

  public GraphFrameReasoner reason() {
    return new GraphFrameReasoner(this);
  }
}

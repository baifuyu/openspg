package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.conf.SPGMapConf;
import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.Filter;
import com.antgroup.openspg.computing.core.plans.logical.LLMExtractor;
import com.antgroup.openspg.computing.core.plans.logical.Mapper;
import com.antgroup.openspg.computing.core.plans.logical.SPGMapper;
import com.antgroup.openspg.computing.core.rdk.struct.Row;
import java.util.function.Function;

public class DataFrame extends Dataset<DataFrame, Row> {

  public DataFrame(QueryExecution queryExecution) {
    super(queryExecution);
  }

  public GraphFrame llmExtract() {
    return new GraphFrame(new QueryExecution(qe.getSpgSession(), new LLMExtractor()));
  }

  public GraphFrame spgMap(SPGMapConf conf) {
    return new GraphFrame(
        new QueryExecution(qe.getSpgSession(), new SPGMapper(qe.getLogicalPlan(), conf)));
  }

  @Override
  public DataFrame map(Function<Row, Row> func) {
    return new DataFrame(
        new QueryExecution(qe.getSpgSession(), new Mapper(qe.getLogicalPlan(), func)));
  }

  @Override
  public DataFrame filter(Function<Row, Boolean> func) {
    return new DataFrame(
        new QueryExecution(qe.getSpgSession(), new Filter(qe.getLogicalPlan(), func)));
  }

  public DataFrameWriter<Row> write() {
    return new DataFrameWriter<>(this);
  }
}

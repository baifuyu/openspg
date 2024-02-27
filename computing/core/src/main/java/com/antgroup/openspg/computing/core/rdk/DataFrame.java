package com.antgroup.openspg.computing.core.rdk;

import com.antgroup.openspg.computing.core.conf.SPGMapConf;
import com.antgroup.openspg.computing.core.plans.QueryExecution;
import com.antgroup.openspg.computing.core.plans.logical.LLMExtractor;
import com.antgroup.openspg.computing.core.plans.logical.MapElements;
import com.antgroup.openspg.computing.core.plans.logical.SPGMap;
import com.antgroup.openspg.computing.core.plans.logical.TypedFilter;
import com.antgroup.openspg.computing.core.rdk.struct.Row;

import java.util.function.Function;

public class DataFrame extends Dataset<DataFrame, Row> {

  public DataFrame(QueryExecution queryExecution) {
    super(queryExecution);
  }

  public GraphFrame llmExtract() {
    return new GraphFrame(new QueryExecution(queryExecution.getSpgSession(), new LLMExtractor()));
  }

  public GraphFrame spgMap(SPGMapConf conf) {
    return new GraphFrame(new QueryExecution(queryExecution.getSpgSession(), new SPGMap()));
  }

  @Override
  public DataFrame map(Function<Row, Row> func) {
    return new DataFrame(new QueryExecution(queryExecution.getSpgSession(), new MapElements(func)));
  }

  @Override
  public DataFrame filter(Function<Row, Boolean> func) {
    return new DataFrame(new QueryExecution(queryExecution.getSpgSession(), new TypedFilter(func)));
  }

  public DataFrameWriter<Row> write() {
    return new DataFrameWriter<>(this);
  }
}

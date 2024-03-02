package com.antgroup.openspg.computing.core.plans;

import com.antgroup.openspg.computing.core.plans.logical.*;
import com.antgroup.openspg.computing.core.plans.physical.*;

public class SPGPlanner {

  public PhysicalPlan<?> plan(LogicalPlan plan) {
    if (plan instanceof DataFrameSourceReader) {
      DataFrameSourceReader reader = ((DataFrameSourceReader) plan);
      return new DataFrameSourceReaderExec(reader.getUri());
    } else if (plan instanceof Mapper) {
      Mapper mapper = ((Mapper) plan);
      return new MapperExec(plan(mapper.getChild()), mapper.getFunc());
    } else if (plan instanceof Filter) {
      Filter filter = ((Filter) plan);
      return new FilterExec(plan(filter.getChild()), filter.getFunc());
    } else if (plan instanceof SPGMapper) {
      SPGMapper mapper = (SPGMapper) plan;
      return new SPGMapperExec(plan(mapper.getChild()), mapper.getConf());
    } else if (plan instanceof SinkWriter) {
      SinkWriter writer = (SinkWriter) plan;
      return new SinkWriterExec(plan(writer.getChild()));
    } else {
      throw new RuntimeException("unknown plan=" + plan.getClass().getSimpleName());
    }
  }
}

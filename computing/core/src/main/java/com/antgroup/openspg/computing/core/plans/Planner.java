package com.antgroup.openspg.computing.core.plans;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.plans.logical.*;
import com.antgroup.openspg.computing.core.plans.physical.*;

public class Planner {

  public PhysicalPlan plan(LogicalPlan plan, SPGSession spgSession) {
    PhysicalPlan physicalPlan = null;
    if (plan instanceof DataFrameSourceReader) {
      DataFrameSourceReader reader = ((DataFrameSourceReader) plan);
      physicalPlan = new DataFrameSourceReaderExec(reader.getUri());
    } else if (plan instanceof Mapper) {
      Mapper mapper = ((Mapper) plan);
      physicalPlan = new MapperExec(plan(mapper.getChild(), spgSession), mapper.getFunc());
    } else if (plan instanceof Filter) {
      Filter filter = ((Filter) plan);
      physicalPlan = new FilterExec(plan(filter.getChild(), spgSession), filter.getFunc());
    } else if (plan instanceof SPGMapper) {
      SPGMapper mapper = (SPGMapper) plan;
      physicalPlan = new SPGMapperExec(plan(mapper.getChild(), spgSession), mapper.getConf());
    } else if (plan instanceof SinkWriter) {
      SinkWriter writer = (SinkWriter) plan;
      physicalPlan = new SinkWriterExec(plan(writer.getChild(), spgSession));
    } else {
      throw new RuntimeException("unknown plan=" + plan.getClass().getSimpleName());
    }
    physicalPlan.setSpgSession(spgSession);
    return physicalPlan;
  }
}

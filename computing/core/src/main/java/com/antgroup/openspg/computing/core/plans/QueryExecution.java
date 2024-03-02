package com.antgroup.openspg.computing.core.plans;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.plans.logical.LogicalPlan;
import com.antgroup.openspg.computing.core.plans.physical.PhysicalPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryExecution {

  private final SPGSession spgSession;
  private final LogicalPlan logicalPlan;

  public void execute() {
    PhysicalPlan physicalPlan = spgSession.getPlanner().plan(logicalPlan, spgSession);
    physicalPlan.execute();
  }
}

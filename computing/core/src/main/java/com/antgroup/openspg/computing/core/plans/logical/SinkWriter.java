package com.antgroup.openspg.computing.core.plans.logical;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SinkWriter extends LogicalPlan {

  private final LogicalPlan child;
}

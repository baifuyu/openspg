package com.antgroup.openspg.computing.core.plans.logical;

import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mapper extends LogicalPlan {

  private final LogicalPlan child;

  private final Function<?, ?> func;
}

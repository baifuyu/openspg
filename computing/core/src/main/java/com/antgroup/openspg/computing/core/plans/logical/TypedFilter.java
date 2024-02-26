package com.antgroup.openspg.computing.core.plans.logical;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public class TypedFilter extends LogicalPlan {

  private final Function<?, Boolean> func;
}

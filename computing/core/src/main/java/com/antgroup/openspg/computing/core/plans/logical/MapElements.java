package com.antgroup.openspg.computing.core.plans.logical;

import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MapElements extends LogicalPlan {

  private final Function<?, ?> func;
}

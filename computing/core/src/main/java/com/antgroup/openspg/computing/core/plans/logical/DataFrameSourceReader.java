package com.antgroup.openspg.computing.core.plans.logical;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataFrameSourceReader extends LogicalPlan {

  private final String uri;
}

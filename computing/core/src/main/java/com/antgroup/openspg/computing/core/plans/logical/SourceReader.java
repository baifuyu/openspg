package com.antgroup.openspg.computing.core.plans.logical;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SourceReader extends LogicalPlan {

  private final String format;

  private final String uri;
}

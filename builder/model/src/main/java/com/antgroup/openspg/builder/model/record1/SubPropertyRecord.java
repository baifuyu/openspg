package com.antgroup.openspg.builder.model.record1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubPropertyRecord extends BaseRecord {

  private final String predicate;

  private final String object;
}

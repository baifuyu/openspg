package com.antgroup.openspg.builder.model.record;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubPropertyRecord extends BaseRecord {

  private final String predicate;

  private final String object;
}

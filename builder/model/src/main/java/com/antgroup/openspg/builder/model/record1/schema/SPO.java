package com.antgroup.openspg.builder.model.record1.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPO implements Subject {

  private final Subject subject;

  private final Predicate predicate;

  private final Object object;

  @Override
  public Identifier getIdentifier() {
    return null;
  }
}

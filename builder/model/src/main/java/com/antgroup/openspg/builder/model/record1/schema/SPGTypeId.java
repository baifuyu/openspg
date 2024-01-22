package com.antgroup.openspg.builder.model.record1.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPGTypeId implements Identifier, Subject, Object {

  private final String namespace;

  private final String val;

  @Override
  public String id() {
    return String.format("%s.%s", namespace, val);
  }

  @Override
  public Identifier getIdentifier() {
    return this;
  }
}

package com.antgroup.openspg.builder.model.record1.schema;

import lombok.Getter;

@Getter
public class Relation extends SPO {

  private final SubProperty subProperty;

  public Relation(
      SPGTypeId subject, Predicate predicate, SPGTypeId object, SubProperty subProperty) {
    super(subject, predicate, object);
    this.subProperty = subProperty;
  }
}

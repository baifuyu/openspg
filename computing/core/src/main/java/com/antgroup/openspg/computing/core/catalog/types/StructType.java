package com.antgroup.openspg.computing.core.catalog.types;

import java.util.List;
import java.util.stream.Collectors;

public class StructType extends DataType {

  private final List<StructField> fields;

  public StructType(List<StructField> fields) {
    this.fields = fields;
  }

  public List<String> fieldNames() {
    return fields.stream().map(StructField::getName).collect(Collectors.toList());
  }
}

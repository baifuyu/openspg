package com.antgroup.openspg.computing.core.catalog.types;

import lombok.Getter;

@Getter
public class StructField {

  private final String name;
  private final DataType dataType;

  public StructField(String name, DataType dataType) {
    this.name = name;
    this.dataType = dataType;
  }
}

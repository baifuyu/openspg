/*
 * Copyright 2023 OpenSPG Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 */

package com.antgroup.openspg.reasoner.common.table;

import java.io.Serializable;

public class Field implements Serializable {
  private final String name;
  private final FieldType type;

  public Field(String name, FieldType type) {
    this.name = name;
    this.type = type;
  }

  /**
   * Getter method for property <tt>name</tt>.
   *
   * @return property value of name
   */
  public String getName() {
    return name;
  }

  /**
   * Getter method for property <tt>type</tt>.
   *
   * @return property value of type
   */
  public FieldType getType() {
    return type;
  }
}

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

package com.antgroup.openspg.reasoner.udf.model;

import com.antgroup.openspg.reasoner.common.types.KgType;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseUdtf {
  private final ArrayList<List<Object>> collector = new ArrayList<>();

  /**
   * udtf input row data type list
   *
   * @return
   */
  public abstract List<KgType> getInputRowTypes();

  /**
   * udtf result type list
   *
   * @return
   */
  public abstract List<KgType> getResultTypes();

  public abstract void process(List<Object> args);

  public void initialize(Object... parameters) {}

  protected void forward(List<Object> outs) {
    this.collector.add(outs);
  }

  public List<List<Object>> getCollector() {
    this.collector.trimToSize();
    return this.collector;
  }
}

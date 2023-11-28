/*
 * Copyright 2023 Ant Group CO., Ltd.
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

package com.antgroup.openspg.builder.core.physical;

import com.antgroup.openspg.builder.model.record.BaseRecord;
import com.antgroup.openspg.server.api.facade.JSON;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/** The transmission protocol used for basic data, with a format of key-value (KV). */
@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BuilderRecord extends BaseRecord {

  /** record id */
  private final String recordId;

  /** Key-value representation of a single data record. */
  private final Map<String, String> props;

  @Override
  public String toString() {
    return JSON.serialize(this);
  }
}

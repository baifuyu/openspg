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

package com.antgroup.openspg.core.spgreasoner.model.struct;

import com.antgroup.openspg.common.model.base.BaseToString;
import java.util.Set;

public class StartingVertex extends BaseToString {

  private String typeName;

  private Set<String> bizIds;

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public Set<String> getBizIds() {
    return bizIds;
  }

  public void setBizIds(Set<String> bizIds) {
    this.bizIds = bizIds;
  }
}

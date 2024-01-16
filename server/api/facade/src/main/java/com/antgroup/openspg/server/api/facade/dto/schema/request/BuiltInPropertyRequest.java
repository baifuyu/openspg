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

package com.antgroup.openspg.server.api.facade.dto.schema.request;

import com.antgroup.openspg.core.schema.model.type.SPGTypeEnum;
import com.antgroup.openspg.server.common.model.base.BaseRequest;

/** Request to query built-in properties of a kind of spg type. */
public class BuiltInPropertyRequest extends BaseRequest {

  private static final long serialVersionUID = 6324173881877135981L;

  /**
   * The spg type that to query
   *
   * @see SPGTypeEnum
   */
  private SPGTypeEnum spgTypeEnum;

  public SPGTypeEnum getSpgTypeEnum() {
    return spgTypeEnum;
  }

  public void setSpgTypeEnum(SPGTypeEnum spgTypeEnum) {
    this.spgTypeEnum = spgTypeEnum;
  }
}

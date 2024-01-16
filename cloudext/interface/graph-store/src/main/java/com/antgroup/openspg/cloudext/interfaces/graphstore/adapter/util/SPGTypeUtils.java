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

package com.antgroup.openspg.cloudext.interfaces.graphstore.adapter.util;

import com.antgroup.openspg.core.schema.model.type.BaseSPGType;
import com.antgroup.openspg.core.schema.model.type.BasicTypeEnum;
import com.antgroup.openspg.core.schema.model.type.SPGTypeEnum;
import com.antgroup.openspg.core.schema.model.type.SPGTypeRef;
import com.antgroup.openspg.server.common.model.exception.GraphStoreException;

/** Utils for {@link BaseSPGType SPGType}. */
public class SPGTypeUtils {

  /**
   * This method is used to convert to {@link BasicTypeEnum BasicType} from {@link SPGTypeRef
   * SPGTypeRef}.
   *
   * @param spgTypeRef reference of SPG type
   * @return {@link BasicTypeEnum} if SPG type is basic type, throw {@link GraphStoreException}
   *     otherwise.
   */
  public static BasicTypeEnum toBasicType(SPGTypeRef spgTypeRef) {
    if (spgTypeRef.getSpgTypeEnum() == null) {
      throw GraphStoreException.unexpectedSPGTypeEnum(spgTypeRef.getSpgTypeEnum());
    }
    if (SPGTypeEnum.BASIC_TYPE.equals(spgTypeRef.getSpgTypeEnum())) {
      BasicTypeEnum basicType = BasicTypeEnum.from(spgTypeRef.getName());
      switch (basicType) {
        case DOUBLE:
          return BasicTypeEnum.DOUBLE;
        case LONG:
          return BasicTypeEnum.LONG;
        default:
          return BasicTypeEnum.TEXT;
      }
    }
    return BasicTypeEnum.TEXT;
  }
}

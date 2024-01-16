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

package com.antgroup.openspg.server.core.schema.service.alter.check;

import com.antgroup.openspg.core.schema.model.type.OperatorKey;

public class OperatorChecker {

  public static void check(String uniqueName, OperatorKey operatorKey) {
    if (null == operatorKey) {
      return;
    }
    if (null == operatorKey.getName()) {
      throw new IllegalArgumentException(
          String.format("operator name of type: %s is null", uniqueName));
    }

    if (null == operatorKey.getVersion()) {
      throw new IllegalArgumentException(
          String.format("operator version of type: %s is null", uniqueName));
    }
  }
}

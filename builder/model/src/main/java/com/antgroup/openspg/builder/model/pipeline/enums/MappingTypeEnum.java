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

package com.antgroup.openspg.builder.model.pipeline.enums;

/**
 * The mapping types of mapping nodes are mainly divided into SPG mapping and relationship mapping.
 */
public enum MappingTypeEnum {
  /** The type of Spg mapping, include entity, concept, standard type, event and basic type. */
  SPG_TYPE,

  /** The type of relationship mapping. */
  RELATION,
  ;
}

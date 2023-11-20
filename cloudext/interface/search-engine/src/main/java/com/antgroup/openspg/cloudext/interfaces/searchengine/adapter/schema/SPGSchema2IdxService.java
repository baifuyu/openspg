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

package com.antgroup.openspg.cloudext.interfaces.searchengine.adapter.schema;

import com.antgroup.openspg.cloudext.interfaces.searchengine.model.idx.schema.IdxSchemaAlterItem;
import com.antgroup.openspg.core.spgschema.model.SPGSchema;
import java.util.List;

public interface SPGSchema2IdxService {

  /**
   * This method is used to generate {@link IdxSchemaAlterItem} by {@link SPGSchema}
   *
   * @param spgSchema the {@link SPGSchema}
   * @return a list of {@link IdxSchemaAlterItem IdxSchemaAlterItem}
   */
  List<IdxSchemaAlterItem> generate(SPGSchema spgSchema);
}

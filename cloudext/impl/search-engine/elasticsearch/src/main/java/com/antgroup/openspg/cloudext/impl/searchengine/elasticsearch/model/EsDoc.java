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

package com.antgroup.openspg.cloudext.impl.searchengine.elasticsearch.model;

import com.antgroup.openspg.server.common.model.base.BaseValObj;
import java.util.Map;
import lombok.Data;

@Data
public class EsDoc extends BaseValObj {

  private String _index;
  private String _id;
  private double _score;
  private Map<String, Object> _source;
}

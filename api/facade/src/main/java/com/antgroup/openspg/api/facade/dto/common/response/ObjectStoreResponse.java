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

package com.antgroup.openspg.api.facade.dto.common.response;

import com.antgroup.openspg.common.model.base.BaseResponse;

public class ObjectStoreResponse extends BaseResponse {

  private String relativePath;

  private String absolutePath;

  public String getRelativePath() {
    return relativePath;
  }

  public ObjectStoreResponse setRelativePath(String relativePath) {
    this.relativePath = relativePath;
    return this;
  }

  public String getAbsolutePath() {
    return absolutePath;
  }

  public ObjectStoreResponse setAbsolutePath(String absolutePath) {
    this.absolutePath = absolutePath;
    return this;
  }
}

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

package com.antgroup.openspg.cloudext.impl.repository.jdbc.dataobject;

public class DataSourceDOWithBLOBs extends DataSourceDO {
  private String connInfo;

  private String physicalInfo;

  public String getConnInfo() {
    return connInfo;
  }

  public void setConnInfo(String connInfo) {
    this.connInfo = connInfo == null ? null : connInfo.trim();
  }

  public String getPhysicalInfo() {
    return physicalInfo;
  }

  public void setPhysicalInfo(String physicalInfo) {
    this.physicalInfo = physicalInfo == null ? null : physicalInfo.trim();
  }
}

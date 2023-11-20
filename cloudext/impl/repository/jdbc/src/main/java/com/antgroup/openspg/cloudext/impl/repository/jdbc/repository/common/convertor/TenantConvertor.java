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

package com.antgroup.openspg.cloudext.impl.repository.jdbc.repository.common.convertor;

import com.antgroup.openspg.cloudext.impl.repository.jdbc.dataobject.TenantDO;
import com.antgroup.openspg.common.model.tenant.Tenant;

public class TenantConvertor {

  public static TenantDO toDO(Tenant tenant) {
    TenantDO tenantDO = new TenantDO();

    tenantDO.setId(tenant.getId());
    tenantDO.setName(tenant.getName());
    tenantDO.setDescription(tenant.getDescription());
    return tenantDO;
  }

  public static Tenant toModel(TenantDO domainDO) {
    return new Tenant(domainDO.getId(), domainDO.getName(), domainDO.getDescription());
  }
}

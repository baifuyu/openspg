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

package com.antgroup.openspg.biz.common;

import com.antgroup.openspg.api.facade.dto.common.request.DataSourceCreateRequest;
import com.antgroup.openspg.api.facade.dto.common.request.DataSourceQueryRequest;
import com.antgroup.openspg.api.facade.dto.common.request.DataSourceUsageCreateRequest;
import com.antgroup.openspg.api.facade.dto.common.request.DataSourceUsageQueryRequest;
import com.antgroup.openspg.common.model.datasource.DataSource;
import com.antgroup.openspg.common.model.datasource.DataSourceUsage;
import java.util.List;

public interface DataSourceManager {

  /**
   * Create a data source.
   *
   * @param request Request for create data source
   * @return DataSourceDTO
   */
  DataSource create(DataSourceCreateRequest request);

  /**
   * Query the data sources
   *
   * @param request
   * @return
   */
  List<DataSource> query(DataSourceQueryRequest request);

  /**
   * Mount the data source
   *
   * @param request Request
   * @return The usage of data source
   */
  DataSourceUsage mount(DataSourceUsageCreateRequest request);

  /**
   * Query mounted data sources
   *
   * @param request
   * @return
   */
  List<DataSourceUsage> query(DataSourceUsageQueryRequest request);
}

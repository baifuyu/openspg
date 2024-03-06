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

package com.antgroup.openspg.server.api.http.server.openapi;

import com.antgroup.openspg.server.api.facade.dto.service.request.RelationSamplingRequest;
import com.antgroup.openspg.server.api.facade.dto.service.request.SPGTypeSamplingRequest;
import com.antgroup.openspg.server.api.facade.dto.service.response.RelationInstance;
import com.antgroup.openspg.server.api.facade.dto.service.response.SPGTypeInstance;
import com.antgroup.openspg.server.api.http.server.BaseController;
import com.antgroup.openspg.server.api.http.server.HttpBizCallback;
import com.antgroup.openspg.server.api.http.server.HttpBizTemplate;
import com.antgroup.openspg.server.biz.service.SamplingManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/public/v1/sampling")
public class SamplingController extends BaseController {

  @Autowired private SamplingManager samplingManager;

  @RequestMapping(method = RequestMethod.GET, value = "/spgType")
  public ResponseEntity<Object> spgTypeSampling(SPGTypeSamplingRequest request) {
    return HttpBizTemplate.execute(
        new HttpBizCallback<List<SPGTypeInstance>>() {
          @Override
          public void check() {}

          @Override
          public List<SPGTypeInstance> action() {
            return samplingManager.spgTypeSampling(request);
          }
        });
  }

  @RequestMapping(method = RequestMethod.GET, value = "/relation")
  public ResponseEntity<Object> relationSampling(RelationSamplingRequest request) {
    return HttpBizTemplate.execute(
        new HttpBizCallback<List<RelationInstance>>() {
          @Override
          public void check() {}

          @Override
          public List<RelationInstance> action() {
            return samplingManager.relationSampling(request);
          }
        });
  }
}

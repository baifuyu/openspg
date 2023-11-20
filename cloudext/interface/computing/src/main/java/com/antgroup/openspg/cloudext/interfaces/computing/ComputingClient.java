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

package com.antgroup.openspg.cloudext.interfaces.computing;

import com.antgroup.openspg.cloudext.interfaces.computing.cmd.BuilderJobCanSubmitQuery;
import com.antgroup.openspg.cloudext.interfaces.computing.cmd.BuilderJobProcessQuery;
import com.antgroup.openspg.cloudext.interfaces.computing.cmd.BuilderJobSubmitCmd;
import com.antgroup.openspg.cloudext.interfaces.computing.cmd.ReasonerJobCanSubmitQuery;
import com.antgroup.openspg.cloudext.interfaces.computing.cmd.ReasonerJobProcessQuery;
import com.antgroup.openspg.cloudext.interfaces.computing.cmd.ReasonerJobRunCmd;
import com.antgroup.openspg.cloudext.interfaces.computing.cmd.ReasonerJobSubmitCmd;
import com.antgroup.openspg.common.util.cloudext.CloudExtClient;
import com.antgroup.openspg.core.spgbuilder.model.service.BuilderStatusWithProgress;
import com.antgroup.openspg.core.spgreasoner.model.service.ReasonerStatusWithProgress;
import com.antgroup.openspg.core.spgreasoner.model.service.TableReasonerReceipt;

public interface ComputingClient extends CloudExtClient {

  /* ----------------------- *
  |      Builder Job        |
  * ----------------------- */

  BuilderStatusWithProgress query(BuilderJobProcessQuery query);

  boolean canSubmit(BuilderJobCanSubmitQuery query);

  String submit(BuilderJobSubmitCmd cmd);

  /* ----------------------- *
  |      Reasoner Job       |
  * ----------------------- */

  ReasonerStatusWithProgress query(ReasonerJobProcessQuery query);

  boolean canSubmit(ReasonerJobCanSubmitQuery query);

  String submit(ReasonerJobSubmitCmd cmd);

  TableReasonerReceipt run(ReasonerJobRunCmd cmd);
}

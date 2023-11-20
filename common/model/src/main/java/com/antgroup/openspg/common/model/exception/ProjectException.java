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

package com.antgroup.openspg.common.model.exception;

public class ProjectException extends OpenSPGException {

  private ProjectException(Throwable cause, String messagePattern, Object... args) {
    super(cause, true, true, messagePattern, args);
  }

  private ProjectException(String messagePattern, Object... args) {
    this(null, messagePattern, args);
  }

  public static ProjectException projectNotExist(Long projectId) {
    return new ProjectException("cannot find project with id={}", projectId);
  }

  public static ProjectException projectNameAlreadyExist(String projectName) {
    return new ProjectException(
        "project name:{} has already exist, " + "please change the project name and try again ",
        projectName);
  }

  public static ProjectException namespaceAlreadyExist(String namespace) {
    return new ProjectException(
        "namespace:{} has already exist, " + "please change the namespace and try again ",
        namespace);
  }
}

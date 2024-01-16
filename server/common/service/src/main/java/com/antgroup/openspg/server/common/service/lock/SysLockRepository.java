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

package com.antgroup.openspg.server.common.service.lock;

import com.antgroup.openspg.server.common.service.lock.model.SysLock;
import java.util.List;

public interface SysLockRepository {

  /**
   * Query lock by name.
   *
   * @return
   */
  List<SysLock> queryAllLock();

  /**
   * Check if exist the lock.
   *
   * @param lockName
   * @return
   */
  boolean exist(String lockName);

  /**
   * Add lock
   *
   * @param lockName
   * @param lockValue
   * @return
   */
  boolean addLock(String lockName, String lockValue);

  /**
   * remove lock
   *
   * @param lockName
   * @return
   */
  boolean removeLock(String lockName);
}

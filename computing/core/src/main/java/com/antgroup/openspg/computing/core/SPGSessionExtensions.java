package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.runner.local.LocalSPGRunner;

public class SPGSessionExtensions {

  private SPGRunner runner = new LocalSPGRunner();

  public void registerRunner(SPGRunner runner) {
    this.runner = runner;
  }
}

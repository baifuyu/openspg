package com.antgroup.openspg.builder.core.runtime;

import com.antgroup.openspg.common.catalog.Catalog;
import java.io.Serializable;

public class BuilderSession implements Serializable {

  private final Catalog catalog;

  private final BuilderConf builderConf;

  public BuilderSession(Catalog catalog, BuilderConf builderConf) {
    this.catalog = catalog;
    this.builderConf = builderConf;
  }
}

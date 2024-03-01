package com.antgroup.openspg.computing.core.catalog;

import com.antgroup.openspg.computing.core.catalog.types.SPGType;

public abstract class Catalog {

  public abstract SPGType get(String name);

  public static CatalogBuilder builder() {
    return new CatalogBuilder();
  }
}

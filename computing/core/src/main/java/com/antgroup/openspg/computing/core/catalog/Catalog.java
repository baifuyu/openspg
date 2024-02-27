package com.antgroup.openspg.computing.core.catalog;

public abstract class Catalog {

  public static CatalogBuilder builder() {
    return new CatalogBuilder();
  }
}

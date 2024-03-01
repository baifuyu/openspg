package com.antgroup.openspg.computing.core.catalog.internal;

import com.antgroup.openspg.computing.core.catalog.Catalog;
import com.antgroup.openspg.computing.core.catalog.types.SPGType;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CatalogImpl extends Catalog {

  private final Map<String, SPGType> spgTypes;

  public CatalogImpl(List<SPGType> spgTypes) {
    this.spgTypes =
        spgTypes.stream().collect(Collectors.toMap(SPGType::getName, Function.identity()));
  }

  @Override
  public SPGType get(String name) {
    return spgTypes.get(name);
  }
}

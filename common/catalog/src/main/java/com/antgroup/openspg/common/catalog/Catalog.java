package com.antgroup.openspg.common.catalog;

import com.antgroup.openspg.common.catalog.types.SPGType;

public interface Catalog {

  String currentProject();

  SPGType getSPGType(String identifier);
}

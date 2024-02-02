package com.antgroup.openspg.builder.catalog.common;

import java.io.Serializable;

public interface Catalog extends Serializable {

  SPGType getSPGType(String identifier);
}

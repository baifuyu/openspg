package com.antgroup.openspg.common.catalog.types;

import java.util.Collections;

public class DoubleType extends SPGType {

  public static final DoubleType INSTANCE = new DoubleType();

  private DoubleType() {
    super("Double", Collections.emptyList(), Collections.emptyList());
  }
}

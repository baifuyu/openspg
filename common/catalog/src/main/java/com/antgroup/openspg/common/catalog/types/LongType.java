package com.antgroup.openspg.common.catalog.types;

import java.util.Collections;

public class LongType extends SPGType {

  public static final LongType INSTANCE = new LongType();

  private LongType() {
    super("Long", Collections.emptyList(), Collections.emptyList());
  }
}

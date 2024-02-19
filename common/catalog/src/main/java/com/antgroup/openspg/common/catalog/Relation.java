package com.antgroup.openspg.common.catalog;

import com.antgroup.openspg.common.catalog.types.SPGType;
import lombok.Getter;

@Getter
public class Relation extends Property {

  public Relation(String predicate, SPGType oType) {
    super(predicate, oType);
  }
}

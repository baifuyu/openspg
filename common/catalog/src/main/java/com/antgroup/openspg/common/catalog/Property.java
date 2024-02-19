package com.antgroup.openspg.common.catalog;

import com.antgroup.openspg.common.catalog.types.SPGType;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class Property implements Serializable {

  private final String predicate;

  private final SPGType oType;

  public Property(String predicate, SPGType oType) {
    this.predicate = predicate;
    this.oType = oType;
  }
}

package com.antgroup.openspg.computing.core.catalog;

import com.antgroup.openspg.computing.core.catalog.types.SPGType;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class Property implements Serializable {

  private final String p;

  private final SPGType o;

  public Property(String p, SPGType o) {
    this.p = p;
    this.o = o;
  }
}

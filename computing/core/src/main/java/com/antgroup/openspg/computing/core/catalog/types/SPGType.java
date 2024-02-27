package com.antgroup.openspg.computing.core.catalog.types;

import com.antgroup.openspg.computing.core.catalog.Property;
import com.antgroup.openspg.computing.core.catalog.Relation;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;

@Getter
public abstract class SPGType implements Serializable {

  private final String name;

  private final List<Property> properties;

  private final List<Relation> relations;

  public SPGType(String name, List<Property> properties, List<Relation> relations) {
    this.name = name;
    this.properties = properties;
    this.relations = relations;
  }
}

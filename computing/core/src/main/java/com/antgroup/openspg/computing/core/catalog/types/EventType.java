package com.antgroup.openspg.computing.core.catalog.types;

import com.antgroup.openspg.computing.core.catalog.Property;
import com.antgroup.openspg.computing.core.catalog.Relation;
import java.util.List;

public class EventType extends SPGType {

  public EventType(String name, List<Property> properties, List<Relation> relations) {
    super(name, properties, relations);
  }
}

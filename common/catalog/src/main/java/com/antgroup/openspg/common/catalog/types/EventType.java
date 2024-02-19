package com.antgroup.openspg.common.catalog.types;

import com.antgroup.openspg.common.catalog.Property;
import com.antgroup.openspg.common.catalog.Relation;
import java.util.List;

public class EventType extends SPGType {

  public EventType(String identifier, List<Property> properties, List<Relation> relations) {
    super(identifier, properties, relations);
  }
}

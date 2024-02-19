package com.antgroup.openspg.common.catalog.types;

import com.antgroup.openspg.common.catalog.Property;
import com.antgroup.openspg.common.catalog.Relation;
import java.util.List;
import lombok.Getter;

@Getter
public class EntityType extends SPGType {

  public EntityType(String identifier, List<Property> properties, List<Relation> relations) {
    super(identifier, properties, relations);
  }
}

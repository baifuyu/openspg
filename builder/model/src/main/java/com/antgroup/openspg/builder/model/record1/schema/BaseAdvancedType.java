package com.antgroup.openspg.builder.model.record1.schema;

import java.util.List;

public class BaseAdvancedType extends BaseSPGType {

  public BaseAdvancedType(
      Identifier identifier, List<Property> properties, List<Relation> relations) {
    super(identifier, properties, relations);
  }
}

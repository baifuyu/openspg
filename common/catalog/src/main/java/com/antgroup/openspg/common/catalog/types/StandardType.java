package com.antgroup.openspg.common.catalog.types;

import com.antgroup.openspg.common.catalog.Property;
import com.antgroup.openspg.common.catalog.Relation;
import java.util.List;
import lombok.Getter;

@Getter
public class StandardType extends SPGType {

  private final boolean spreadable;

  public StandardType(
      String identifier, List<Property> properties, List<Relation> relations, boolean spreadable) {
    super(identifier, properties, relations);
    this.spreadable = spreadable;
  }
}

package com.antgroup.openspg.common.catalog.types;

import com.antgroup.openspg.common.catalog.Property;
import com.antgroup.openspg.common.catalog.Relation;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import lombok.Getter;

@Getter
public abstract class SPGType implements Serializable {

  private final String identifier;

  private final List<Property> properties;

  private final List<Relation> relations;

  public SPGType(String identifier, List<Property> properties, List<Relation> relations) {
    this.identifier = identifier;
    this.properties = properties;
    this.relations = relations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SPGType)) return false;
    SPGType spgType = (SPGType) o;
    return Objects.equals(getIdentifier(), spgType.getIdentifier());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIdentifier());
  }
}

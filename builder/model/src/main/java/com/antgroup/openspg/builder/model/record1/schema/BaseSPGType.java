package com.antgroup.openspg.builder.model.record1.schema;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class BaseSPGType implements Serializable {

  private final SPGTypeId identifier;

  private final List<Property> properties;

  private final List<Relation> relations;
}

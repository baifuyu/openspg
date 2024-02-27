package com.antgroup.openspg.computing.core.rdk.struct;

import com.antgroup.openspg.computing.core.catalog.types.SPGType;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubGraphImpl implements SubGraph {

  private final String subject;
  private final List<SPO> properties;
  private final List<SPO> relations;

  private final SPGType schema;

  @Override
  public SPGType schema() {
    return schema;
  }

  @Override
  public String subject() {
    return subject;
  }

  @Override
  public List<SPO> relations() {
    return relations;
  }

  @Override
  public List<SPO> properties() {
    return properties;
  }
}

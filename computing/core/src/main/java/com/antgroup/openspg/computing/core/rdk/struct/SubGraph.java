package com.antgroup.openspg.computing.core.rdk.struct;

import com.antgroup.openspg.computing.core.catalog.types.SPGType;

public interface SubGraph extends Raw {

  SPGType schema();

  String subject();

  <T> T getPropertyValue(String pName);

  <T> T getRelationValue(String pName);
}

package com.antgroup.openspg.computing.core.rdk.struct;

import com.antgroup.openspg.computing.core.catalog.types.StructType;

public interface Row extends Raw {

  int size();

  default int length() {
    return size();
  }

  StructType schema();

  Object get(int idx);

  <T> T getAs(int idx);

  <T> T getAs(String fieldName);
}

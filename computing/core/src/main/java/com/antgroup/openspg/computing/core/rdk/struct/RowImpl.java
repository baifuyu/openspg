package com.antgroup.openspg.computing.core.rdk.struct;

import com.antgroup.openspg.computing.core.catalog.types.StructType;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RowImpl implements Row {

  private final List<Object> values;
  private final StructType schema;

  @Override
  public int size() {
    return values.size();
  }

  @Override
  public StructType schema() {
    return schema;
  }

  @Override
  public Object get(int i) {
    return values.get(i);
  }
}

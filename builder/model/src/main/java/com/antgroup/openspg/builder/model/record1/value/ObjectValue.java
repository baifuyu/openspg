package com.antgroup.openspg.builder.model.record1.value;

import com.antgroup.openspg.builder.model.record1.schema.Object;

import java.io.Serializable;

public interface ObjectValue extends Serializable {

  String getBizId();

  Object getObject();
}

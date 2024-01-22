package com.antgroup.openspg.builder.model.record1.value;

import com.antgroup.openspg.builder.model.record1.schema.Subject;
import java.io.Serializable;

public interface SubjectValue extends Serializable {

  String getBizId();

  Subject getSubject();
}

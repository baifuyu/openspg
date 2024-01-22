package com.antgroup.openspg.builder.model.record1.value;

import com.antgroup.openspg.builder.model.record.BaseRecord;
import com.antgroup.openspg.builder.model.record1.schema.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class SPORecord extends BaseRecord implements SubjectValue {

  @Setter private SubjectValue subjectValue;

  private final PredicateValue predicateValue;

  private final ObjectValue objectValue;

  @Override
  public String getBizId() {
    return null;
  }

  @Override
  public Subject getSubject() {
    return null;
  }
}

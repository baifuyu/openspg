package com.antgroup.openspg.builder.model.record;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPORecord extends BaseRecord {

  private final String predicate;

  private final String object;

  private final List<SubPropertyRecord> subPropertyRecords;
}

package com.antgroup.openspg.builder.model.record;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPGRecord extends BaseRecord {

  private final String identifier;

  private final String subject;

  private final List<SPORecord> properties;

  private final List<SPORecord> relations;
}

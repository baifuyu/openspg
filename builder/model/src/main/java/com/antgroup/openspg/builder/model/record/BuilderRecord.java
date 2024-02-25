package com.antgroup.openspg.builder.model.record;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BuilderRecord extends BaseRecord {

  private final Map<String, String> props;
}

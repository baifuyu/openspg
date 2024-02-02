package com.antgroup.openspg.builder.model.record1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class SPGRecordManipulateCmd implements Serializable {

  private final List<SPGRecordAlterItem> alterItems;
}

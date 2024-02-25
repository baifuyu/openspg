package com.antgroup.openspg.builder.model.record;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPGRecordAlterItem implements Serializable {

  private final SPGRecord spgRecord;

  private final RecordAlterOperationEnum alterOp;
}

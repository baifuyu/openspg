package com.antgroup.openspg.builder.model.record;

import com.sun.org.apache.xml.internal.resolver.Catalog;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPGRecordManipulateCmd implements Serializable {

  private final Catalog catalog;

  private final List<SPGRecordAlterItem> alterItems;
}

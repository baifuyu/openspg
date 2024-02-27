package com.antgroup.openspg.computing.core.rdk.struct;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPO implements Serializable {
  private final String s;
  private final String p;
  private final String o;
}

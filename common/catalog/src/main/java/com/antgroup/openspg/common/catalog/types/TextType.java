package com.antgroup.openspg.common.catalog.types;

import java.util.Collections;

public class TextType extends SPGType {

  public static final TextType INSTANCE = new TextType();

  public TextType() {
    super("Text", Collections.emptyList(), Collections.emptyList());
  }
}

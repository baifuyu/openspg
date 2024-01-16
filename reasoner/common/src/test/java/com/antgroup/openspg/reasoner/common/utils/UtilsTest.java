/*
 * Copyright 2023 OpenSPG Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 */

package com.antgroup.openspg.reasoner.common.utils;

import com.antgroup.openspg.reasoner.common.Utils;
import com.antgroup.openspg.reasoner.common.table.Field;
import com.antgroup.openspg.reasoner.common.table.FieldType;
import com.antgroup.openspg.reasoner.common.types.KTBoolean$;
import com.antgroup.openspg.reasoner.common.types.KTString$;
import com.antgroup.openspg.reasoner.common.types.KgType;
import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
  @Test
  public void testGetResultTableColumns() {
    java.util.List<String> asList = Lists.newArrayList("A.id", "b.t.id", "XX123");
    List<KgType> typeList = Lists.newArrayList(KTString$.MODULE$, KTBoolean$.MODULE$);
    List<Field> result = Utils.getResultTableColumns(asList, typeList);
    Assert.assertEquals(3, result.size());
    Assert.assertEquals(result.get(0).getName(), "a_id");
    Assert.assertEquals(result.get(0).getType(), FieldType.STRING);
    Assert.assertEquals(result.get(1).getName(), "b_t_id");
    Assert.assertEquals(result.get(1).getType(), FieldType.BOOLEAN);
    Assert.assertEquals(result.get(2).getName(), "xx123");
    Assert.assertEquals(result.get(2).getType(), FieldType.UNKNOWN);
  }
}

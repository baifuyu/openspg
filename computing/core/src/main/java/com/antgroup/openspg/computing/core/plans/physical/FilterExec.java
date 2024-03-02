package com.antgroup.openspg.computing.core.plans.physical;

import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Raw;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilterExec extends PhysicalPlan {

  private final PhysicalPlan child;

  private final Function func;

  @Override
  protected RDK<? extends Raw> doExecute() {
    return child.execute().filter(func);
  }
}

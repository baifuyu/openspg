package com.antgroup.openspg.computing.core.plans.physical;

import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Raw;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataFrameSourceReaderExec extends PhysicalPlan {

  private final String uri;

  @Override
  protected RDK<? extends Raw> doExecute() {
    return spgSession.getRunner().createDataFrame(uri);
  }
}

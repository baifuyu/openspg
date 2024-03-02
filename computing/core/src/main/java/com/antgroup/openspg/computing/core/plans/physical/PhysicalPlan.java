package com.antgroup.openspg.computing.core.plans.physical;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.struct.Raw;
import com.antgroup.openspg.computing.core.trees.TreeNode;
import lombok.Setter;

public abstract class PhysicalPlan extends TreeNode<PhysicalPlan> {

  @Setter protected SPGSession spgSession;

  public final RDK<? extends Raw> execute() {
    return doExecute();
  }

  protected abstract RDK<? extends Raw> doExecute();
}

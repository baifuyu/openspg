package com.antgroup.openspg.computing.core.plans.physical;

import com.antgroup.openspg.computing.core.rdk.RDK;
import com.antgroup.openspg.computing.core.rdk.Raw;
import com.antgroup.openspg.computing.core.trees.TreeNode;

public abstract class PhysicalPlan extends TreeNode<PhysicalPlan> {

  public final RDK<Raw> execute() {
    return doExecute();
  }

  protected abstract RDK<Raw> doExecute();
}

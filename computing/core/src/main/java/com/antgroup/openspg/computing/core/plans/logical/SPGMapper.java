package com.antgroup.openspg.computing.core.plans.logical;

import com.antgroup.openspg.computing.core.conf.SPGMapConf;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPGMapper extends LogicalPlan {

  private final LogicalPlan child;

  private final SPGMapConf conf;
}

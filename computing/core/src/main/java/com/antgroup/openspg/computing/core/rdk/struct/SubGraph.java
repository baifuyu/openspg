package com.antgroup.openspg.computing.core.rdk.struct;

import com.antgroup.openspg.computing.core.catalog.types.SPGType;
import java.util.List;

public interface SubGraph extends Raw {

  SPGType schema();

  String subject();

  List<SPO> relations();

  List<SPO> properties();
}

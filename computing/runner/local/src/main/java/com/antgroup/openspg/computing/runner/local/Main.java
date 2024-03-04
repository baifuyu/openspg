package com.antgroup.openspg.computing.runner.local;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.catalog.Catalog;
import com.antgroup.openspg.computing.core.conf.SPGMapConf;
import com.antgroup.openspg.computing.core.rdk.DataFrame;
import org.apache.commons.lang3.StringUtils;

public class Main {

  public static void testcase1() {
    SPGSession spgSession =
        SPGSession.builder()
            .appName("test")
            .runner(LocalSPGRunner.class)
            .catalog(Catalog.builder().build())
            .getOrCreate();

    DataFrame dataFrame = spgSession.read().csv("input.csv");

    dataFrame
        .filter(row -> StringUtils.isNotBlank(row.getAs("name")))
        .spgMap(
            SPGMapConf.mappingTo("RiskMining.Person")
                .addPropertyMapping(new SPGMapConf.MappingPair("id", "id"))
                .addPropertyMapping(new SPGMapConf.MappingPair("name", "name")))
        .filter(subGraph -> true)
        .write()
        .csv("file://output.csv");
  }

  public static void testcase2() {
    SPGSession spgSession =
        SPGSession.builder()
            .appName("test")
            .runner(LocalSPGRunner.class)
            .catalog(Catalog.builder().build())
            .getOrCreate();

    DataFrame dataFrame = spgSession.read().csv("xxx.csv");

    dataFrame
        .map(row -> row)
        .spgMap(null)
        .patternMatch(null)
        .filter(subGraph -> true)
        .reason()
        .leadTo();
  }
}

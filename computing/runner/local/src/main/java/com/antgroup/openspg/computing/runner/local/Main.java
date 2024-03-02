package com.antgroup.openspg.computing.runner.local;

import com.antgroup.openspg.computing.core.SPGSession;
import com.antgroup.openspg.computing.core.catalog.Catalog;
import com.antgroup.openspg.computing.core.rdk.DataFrame;

public class Main {

  public static void testcase1() {
    SPGSession spgSession =
        SPGSession.builder()
            .appName("test")
            .runner(LocalSPGRunner.class)
            .catalog(Catalog.builder().build())
            .getOrCreate();

    DataFrame dataFrame = spgSession.read().csv("xxx.csv");

    dataFrame
        .map(x -> x)
        .spgMap(null)
        .patternMatch(null)
        .filter(subGraph -> true)
        .write()
        .csv("xxxxx");
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
        .map(x -> x)
        .spgMap(null)
        .patternMatch(null)
        .filter(subGraph -> true)
        .reason()
        .leadTo();
  }
}

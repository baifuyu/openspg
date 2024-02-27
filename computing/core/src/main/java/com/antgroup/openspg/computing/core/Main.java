package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.catalog.Catalog;
import com.antgroup.openspg.computing.core.rdk.DataFrame;

public class Main {

  public static void main(String[] args) {
    SPGSession spgSession =
        SPGSession.builder()
                .appName("test")
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
}

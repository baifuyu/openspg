package com.antgroup.openspg.computing.core.rdk;

public class DataFrameWriter<T> {

  private final DataFrame df;

  public DataFrameWriter(DataFrame df) {
    this.df = df;
  }

  public void csv(String path) {}
}

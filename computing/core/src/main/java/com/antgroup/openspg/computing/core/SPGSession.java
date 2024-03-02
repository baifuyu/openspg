package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.catalog.Catalog;
import com.antgroup.openspg.computing.core.plans.Planner;
import com.antgroup.openspg.computing.core.rdk.DataFrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SPGSession implements Serializable, Closeable {

  private final Catalog catalog;

  private final Runner runner;

  private final Planner planner = new Planner();

  public DataFrameReader read() {
    return new DataFrameReader(this);
  }

  public static SPGSessionBuilder builder() {
    return new SPGSessionBuilder();
  }

  @Override
  public void close() throws IOException {}
}

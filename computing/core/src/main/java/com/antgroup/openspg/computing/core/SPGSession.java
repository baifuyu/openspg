package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.rdk.DataFrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

public class SPGSession implements Serializable, Closeable {

  private final SPGRunner runner;

  public SPGSession(SPGRunner runner) {
    this.runner = runner;
  }

  public DataFrameReader read() {
    return runner.read(this);
  }

  public SPGSessionBuilder builder() {
    return new SPGSessionBuilder();
  }

  @Override
  public void close() throws IOException {}
}

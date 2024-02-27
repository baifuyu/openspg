package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.catalog.Catalog;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class SPGSessionBuilder {

  private Catalog catalog;
  private final Map<String, String> options = new HashMap<>();

  private final SPGSessionExtensions extensions = new SPGSessionExtensions();

  public SPGSessionBuilder appName(String name) {
    return config("spgx.app.name", name);
  }

  public synchronized SPGSessionBuilder config(String key, String value) {
    options.put(key, value);
    return this;
  }

  public synchronized SPGSessionBuilder catalog(Catalog catalog) {
    this.catalog = catalog;
    return this;
  }

  public synchronized SPGSessionBuilder withExtensions(Consumer<SPGSessionExtensions> f) {
    f.accept(extensions);
    return this;
  }

  public synchronized SPGSession getOrCreate() {
    return new SPGSession(catalog);
  }
}

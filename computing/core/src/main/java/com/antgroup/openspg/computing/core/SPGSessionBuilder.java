package com.antgroup.openspg.computing.core;

import com.antgroup.openspg.computing.core.catalog.Catalog;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SPGSessionBuilder {

  private Catalog catalog;
  private Runner runner;
  private final Map<String, String> options = new HashMap<>();

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

  public synchronized SPGSessionBuilder runner(String runnerClassName) {
    try {
      Class<?> clazz = Class.forName(runnerClassName);
      runner = (Runner) clazz.getConstructor().newInstance();
    } catch (ClassNotFoundException
        | NoSuchMethodException
        | IllegalAccessException
        | InstantiationException
        | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public synchronized SPGSessionBuilder runner(Class<? extends Runner> runnerClass) {
    return runner(runnerClass.getName());
  }

  public synchronized SPGSession getOrCreate() {
    SPGSession spgSession = new SPGSession(catalog, runner);
    runner.setSpgSession(spgSession);
    return spgSession;
  }
}

package com.antgroup.openspg.common.util;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class BaseConf<C extends BaseConf<C>> implements Cloneable, Serializable {

  private static final Map<String, String> settings = new ConcurrentHashMap<>();

  public C set(String key, String value) {
    if (key == null) {
      throw new NullPointerException("null key");
    }
    if (value == null) {
      throw new NullPointerException("null value for " + key);
    }
    settings.put(key, value);
    return (C) this;
  }

  public C remove(String key) {
    settings.remove(key);
    return (C) this;
  }

  public Optional<String> getOption(String key) {
    return Optional.ofNullable(settings.get(key));
  }

  public int getInt(String key, int defaultValue) {
    return catchIllegalValue(key, () -> getOption(key).map(Integer::parseInt).orElse(defaultValue));
  }

  public long getLong(String key, long defaultValue) {
    return catchIllegalValue(key, () -> getOption(key).map(Long::parseLong).orElse(defaultValue));
  }

  public double getDouble(String key, double defaultValue) {
    return catchIllegalValue(
        key, () -> getOption(key).map(Double::parseDouble).orElse(defaultValue));
  }

  public boolean getBoolean(String key, boolean defaultValue) {
    return catchIllegalValue(
        key, () -> getOption(key).map(Boolean::parseBoolean).orElse(defaultValue));
  }

  private <T> T catchIllegalValue(String key, Supplier<T> supplier) {
    try {
      return supplier.get();
    } catch (NumberFormatException e) {
      throw (NumberFormatException)
          new NumberFormatException(
                  String.format("Illegal value for config key %s:%s", key, e.getMessage()))
              .initCause(e);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
          String.format("Illegal value for config key %s:%s", key, e.getMessage()), e);
    }
  }
}

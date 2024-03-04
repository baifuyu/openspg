package com.antgroup.openspg.computing.core.conf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class SPGMapConf implements Serializable {

  private final String spgType;
  private final List<MappingPair> propertyMappingPairs = new ArrayList<>();
  private final List<MappingPair> relationMappingPairs = new ArrayList<>();

  private SPGMapConf(String spgType) {
    this.spgType = spgType;
  }

  public static SPGMapConf mappingTo(String spgType) {
    return new SPGMapConf(spgType);
  }

  public SPGMapConf addPropertyMapping(MappingPair pair) {
    propertyMappingPairs.add(pair);
    return this;
  }

  public SPGMapConf addRelationMapping(MappingPair pair) {
    relationMappingPairs.add(pair);
    return this;
  }

  @Getter
  public static class MappingPair {
    private final String src;
    private final String dst;
    private final String dstType;
    private final List<SubMappingPair> subMappingPairs = new ArrayList<>();

    public MappingPair(String src, String dst) {
      this(src, dst, null);
    }

    public MappingPair(String src, String dst, String dstType) {
      this.src = src;
      this.dst = dst;
      this.dstType = dstType;
    }

    public MappingPair addSubMapping(SubMappingPair subMappingPair) {
      subMappingPairs.add(subMappingPair);
      return this;
    }
  }

  @Getter
  public static class SubMappingPair {
    private final String src;
    private final String dst;
    private final String dstType;

    public SubMappingPair(String src, String dst) {
      this(src, dst, null);
    }

    public SubMappingPair(String src, String dst, String dstType) {
      this.src = src;
      this.dst = dst;
      this.dstType = dstType;
    }
  }
}

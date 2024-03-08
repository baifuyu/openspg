/*
 * Copyright 2023 OpenSPG Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 */

package com.antgroup.openspg.cloudext.interfaces.graphstore.cmd;

import com.antgroup.openspg.cloudext.interfaces.graphstore.LPGTypeNameConvertor;
import com.antgroup.openspg.cloudext.interfaces.graphstore.model.Direction;
import com.antgroup.openspg.cloudext.interfaces.graphstore.model.lpg.schema.EdgeTypeName;
import java.util.Set;
import java.util.stream.Collectors;

public class ObjectVertexRecordQuery extends BaseLPGRecordQuery {

  private final String srcVertexId;
  private final String srcVertexName;
  private final Set<EdgeTypeName> edgeNames;
  private final Direction direction;

  public ObjectVertexRecordQuery(
      String srcVertexId, String srcVertexName, Set<EdgeTypeName> edgeNames, Direction direction) {
    super(LpgRecordQueryType.OBJECT_VERTEX);

    this.srcVertexId = srcVertexId;
    this.srcVertexName = srcVertexName;
    this.edgeNames = edgeNames;
    this.direction = direction == null ? Direction.BOTH : direction;
  }

  @Override
  public String toScript(LPGTypeNameConvertor lpgTypeNameConvertor) {
    StringBuilder edgeNameStr = new StringBuilder();
    if (edgeNames != null) {
      if (edgeNames.isEmpty()) {
        throw new IllegalArgumentException();
      }
      edgeNameStr
          .append(":")
          .append(
              edgeNames.stream()
                  .map(lpgTypeNameConvertor::convertEdgeTypeName)
                  .collect(Collectors.joining("|")));
    }

    String convertedSrcVertexName = lpgTypeNameConvertor.convertVertexTypeName(srcVertexName);
    switch (direction) {
      case OUT:
        return String.format(
            "MATCH (s:%s)-[p%s]->(o) WHERE s.id='%s' RETURN o;",
            convertedSrcVertexName, edgeNameStr, srcVertexId);
      case IN:
        return String.format(
            "MATCH (s:%s)<-[p%s]-(o) WHERE s.id='%s' RETURN o;",
            convertedSrcVertexName, edgeNameStr, srcVertexId);
      case BOTH:
        return String.format(
            "MATCH (s:%s)<-[p%s]->(o) WHERE s.id='%s' RETURN o;",
            convertedSrcVertexName, edgeNameStr, srcVertexId);
      default:
        throw new IllegalArgumentException("illegal direction=" + direction);
    }
  }
}

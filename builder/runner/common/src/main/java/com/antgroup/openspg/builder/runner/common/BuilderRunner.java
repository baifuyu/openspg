package com.antgroup.openspg.builder.runner.common;

import com.antgroup.openspg.builder.core.runtime.BuilderContext;
import com.antgroup.openspg.builder.model.pipeline.Pipeline;

public interface BuilderRunner {

  void init(Pipeline pipeline, BuilderContext context);

  void execute() throws Exception;

  void close() throws Exception;
}

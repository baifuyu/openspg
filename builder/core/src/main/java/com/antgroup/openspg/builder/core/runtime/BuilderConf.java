package com.antgroup.openspg.builder.core.runtime;

import com.antgroup.openspg.common.util.BaseConf;

public class BuilderConf extends BaseConf<BuilderConf> {

  public BuilderConf setProjectId(long projectId) {
    return set("builder.project.id", String.valueOf(projectId));
  }

  public BuilderConf setJobName(String jobName) {
    return set("builder.job.name", jobName);
  }
}

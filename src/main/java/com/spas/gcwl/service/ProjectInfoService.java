package com.spas.gcwl.service;

import com.spas.gcwl.entity.ProjectInfo;

import java.util.List;

public interface ProjectInfoService {
    int submitProjectInfo(ProjectInfo projectInfo);

    List<ProjectInfo> findAllSubmittedProjectInfoByUserme(String userme);
    List<ProjectInfo> findAllSubmittedProjectInfo();
    List<ProjectInfo> findAllProcessedProjectInfoByHanler(String handler_name);
    ProjectInfo findProjectInfoById(Integer project_id);

    int processSubmittedProjectInfoById(ProjectInfo projectInfo);
    int reprocessProjectInfoById(Integer project_id);
    int processingProjectInfoById(Integer project_id);
    int commitProjectInfoById(Integer project_id);
}

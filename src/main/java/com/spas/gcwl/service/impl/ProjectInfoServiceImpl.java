package com.spas.gcwl.service.impl;

import com.spas.gcwl.dao.ProjectInfoMapper;
import com.spas.gcwl.entity.ProjectInfo;
import com.spas.gcwl.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Autowired
    ProjectInfoMapper projectInfoMapper;

    @Override
    public int submitProjectInfo(ProjectInfo projectInfo) {
        return projectInfoMapper.submitProjectInfo(projectInfo);
    }

    @Override
    public List<ProjectInfo> findAllSubmittedProjectInfoByUserme(String userme) {
        return projectInfoMapper.findAllSubmittedProjectInfoByUserme(userme);
    }

    @Override
    public List<ProjectInfo> findAllSubmittedProjectInfo() {
        return projectInfoMapper.findAllSubmittedProjectInfo();
    }

    @Override
    public List<ProjectInfo> findAllProcessedProjectInfoByHanler(String handler_name) {
        return projectInfoMapper.findAllProcessedProjectInfoByHandler(handler_name);
    }

    @Override
    public ProjectInfo findProjectInfoById(Integer project_id) {
        return projectInfoMapper.findProjectInfoById(project_id);
    }

    @Override
    public int processSubmittedProjectInfoById(ProjectInfo projectInfo) {
        return projectInfoMapper.processSubmittedProjectInfoById(projectInfo);
    }

    @Override
    public int reprocessProjectInfoById(Integer project_id) {
        return projectInfoMapper.repocessProjectInfoById(project_id);
    }

    @Override
    public int processingProjectInfoById(Integer project_id) {
        return projectInfoMapper.processingProjectInfoById(project_id);
    }

    @Override
    public int commitProjectInfoById(ProjectInfo projectInfo) {
        return projectInfoMapper.commitProjectInfoById(projectInfo);
    }

    public int deleteProjecctInfoById(Integer project_id){
        return  projectInfoMapper.deleteProjecctInfoById(project_id);
    }
}

package com.spas.gcwl.service.impl;

import com.spas.gcwl.dao.ProjectACarMapper;
import com.spas.gcwl.entity.ProjectACar;
import com.spas.gcwl.service.ProjectACarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectACarImpl implements ProjectACarService {
    @Autowired
    ProjectACarMapper projectACarMapper;

    @Override
    public int addProjectACar(ProjectACar projectACar) {
        return projectACarMapper.addProjectACar(projectACar);
    }

    @Override
    public List<String> findNumberByProject_id(Integer project_id) {
        return projectACarMapper.findNumberByProject_id(project_id);
    }

    @Override
    public List<Integer> findProject_idByNumber(String number) {
        return projectACarMapper.findProject_idByNumber(number);
    }
}

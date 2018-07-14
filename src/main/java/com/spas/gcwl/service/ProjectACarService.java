package com.spas.gcwl.service;

import com.spas.gcwl.entity.ProjectACar;

import java.util.List;

public interface ProjectACarService {
    int addProjectACar(ProjectACar projectACar);
    List<String> findNumberByProject_id(Integer project_id);
    List<Integer> findProject_idByNumber(String number);
    Integer findAProject_idByNumber(String number);
}

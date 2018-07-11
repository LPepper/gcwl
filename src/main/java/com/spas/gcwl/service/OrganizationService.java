package com.spas.gcwl.service;

import com.spas.gcwl.entity.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationService {
    int insertOrganization(Organization organization);
    List<Organization> findAllOrganization();
    int deleteOrganizationByName(String name);
    Organization findOrganizationById(Integer id);
    int updateInfoById(Organization organization);
    int deleteOrganizationById(Integer id);
}

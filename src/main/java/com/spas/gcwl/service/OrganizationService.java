package com.spas.gcwl.service;

import com.spas.gcwl.entity.Organization;

import java.util.List;

public interface OrganizationService {
    int insertOrganization(Organization organization);
    List<Organization> findAllOrganization();
    int deleteOrganizationByName(String name);
}

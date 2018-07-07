package com.spas.gcwl.service.impl;


import com.spas.gcwl.dao.OrganizationMapper;
import com.spas.gcwl.entity.Organization;
import com.spas.gcwl.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;


    @Override
    public int insertOrganization(Organization organization){
        return  this.organizationMapper.insertOrganization(organization);
    }

    @Override
    public List<Organization> findAllOrganization(){
        return  this.organizationMapper.findAllOrganization();
    }


}

package com.spas.gcwl.service.impl;

import com.spas.gcwl.dao.RoleAuthorityMapper;
import com.spas.gcwl.entity.Role;
import com.spas.gcwl.entity.RoleAuthority;
import com.spas.gcwl.service.RoleAuthorityService;
import com.spas.gcwl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
    @Autowired
    RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public int addRoleAuthority(RoleAuthority roleAuthority) {
        return this.roleAuthorityMapper.addRoleAuthority(roleAuthority);
    }

    @Override
    public Integer findAuthorityByRoleId(Integer Role_id) {
        return this.roleAuthorityMapper.findAuthorityByRoleId(Role_id);
    }

    @Override
    public int deleteColums(RoleAuthority roleAuthority) {
        return this.roleAuthorityMapper.deleteColums(roleAuthority);
    }
}

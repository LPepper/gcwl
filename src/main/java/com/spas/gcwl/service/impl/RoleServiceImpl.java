package com.spas.gcwl.service.impl;

import com.spas.gcwl.dao.RoleMapper;
import com.spas.gcwl.entity.Role;
import com.spas.gcwl.service.RoleService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {
        return this.roleMapper.addRole(role);
    }

    @Override
    public Role findRoleById(Integer id) {
        return this.roleMapper.findRoleById(id);
    }

    @Override
    public List<Role> findAllRole() {
        return this.roleMapper.findAllRole();
    }

    @Override
    public Integer findIdByName(String role_name) {
        return this.roleMapper.findIdByName(role_name);
    }

    @Override
    public int deleteRoleByid(Integer id) {
        return this.roleMapper.deleteRoleByid(id);
    }
}

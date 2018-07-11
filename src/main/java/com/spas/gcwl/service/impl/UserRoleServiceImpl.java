package com.spas.gcwl.service.impl;

import com.spas.gcwl.dao.UserRoleMapper;
import com.spas.gcwl.entity.UserRole;
import com.spas.gcwl.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public int addUserRole(UserRole userRole) {
        return this.userRoleMapper.addUserRole(userRole);
    }

    @Override
    public int deleteALlRoleByName(String userme) {
        return this.userRoleMapper.deleteALlRoleByName(userme);
    }

    @Override
    public List<Integer> findIdByUserme(String userme) {
        return this.userRoleMapper.findIdByUserme(userme);
    }
}

package com.spas.gcwl.service;

import com.spas.gcwl.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    int addRole(Role role);
    Role findRoleById(Integer id);
    List<Role> findAllRole();
    int deleteRoleByid(Integer id);
}

package com.spas.gcwl.service;

import com.spas.gcwl.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    int addUserRole(UserRole userRole);
    List<Integer> findIdByUserme(String userme);
    int deleteALlRoleByName( String userme);
}

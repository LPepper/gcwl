package com.spas.gcwl.service;

import com.spas.gcwl.entity.UserRole;

public interface UserRoleService {
    int addUserRole(UserRole userRole);
    int findIdByUserme(String userme);
}

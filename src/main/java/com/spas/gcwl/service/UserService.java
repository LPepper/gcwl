package com.spas.gcwl.service;

import com.spas.gcwl.entity.User;

import java.util.List;

public interface UserService {

    int insertUser(User user);
    List<User> findAllUser();
    User findByName(String username);
    int updateUserInfoExceptPassword(User user);
    int updateUserPassword(User user);
}

package com.spas.gcwl.service.impl;


import com.spas.gcwl.entity.User;
import com.spas.gcwl.service.OrganizationService;
import com.spas.gcwl.dao.UserMapper;
import com.spas.gcwl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public int insertUser(User user){
        return this.userMapper.insertUser(user);
    }

    @Override
    public List<User> findAllUser(){
        return  this.userMapper.findAllUser();
    }

    @Override
    public User findByName(String username){
        return this.userMapper.findByName(username);
    }

    @Override
    public int updateUserInfoExceptPassword(User user){
        return this.userMapper.updateUserInfoExceptPassword(user);
    }

    @Override
    public int updateUserPassword(User user){
        return this.userMapper.updateUserPassword(user);
    }






}

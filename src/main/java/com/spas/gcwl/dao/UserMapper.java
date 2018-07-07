package com.spas.gcwl.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import com.spas.gcwl.entity.User;
@Component
@Mapper
public interface UserMapper {

    @Insert("insert into User(username,password,phone,organization) values(#{username},#{password},#{phone},#{organization})")
    int insertUser(User user);


}

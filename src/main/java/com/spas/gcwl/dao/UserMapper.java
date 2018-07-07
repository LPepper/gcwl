package com.spas.gcwl.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import com.spas.gcwl.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into User(username,password,phone,organization,pic_url) values(#{username},#{password},#{phone},#{organization},#{pic_url})")
    int insertUser(User user);

    @Select("select * from User")
    List<User> findAllUser();

    @Select("select * from User where username=#{username}")
    User findByName(@Param("username") String username);

    @Update("update User set pic_url=#{pic_url},phone=#{phone},organization=#{organization} where username=#{username}")
    int updateUserInfoExceptPassword(User user);

    @Update("update User set password=#{password} where username=#{username}")
    int updateUserPassword(User user);


}

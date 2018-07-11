package com.spas.gcwl.dao;


import com.spas.gcwl.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleMapper {
    @Insert("insert into Role(role_name,role_description) values(#{role_name},#{role_description})")
    int addRole(Role role);

    @Select("select * from Role where id=#{id}")
    Role findRoleById(@Param("id") Integer id);

    @Select("select id from Role where role_name=#{role_name}")
    Integer findIdByName(@Param("role_name") String role_name);

    @Select("select * from Role ")
    List<Role> findAllRole();



    @Delete("delete from Role where id=#{id}")
    int deleteRoleByid(@Param("id") Integer id);
}

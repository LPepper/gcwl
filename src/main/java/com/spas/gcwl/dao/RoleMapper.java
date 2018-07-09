package com.spas.gcwl.dao;


import com.spas.gcwl.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleMapper {
    @Insert("insert into Role(id,role_name) values(#{id},#{role_name})")
    int addRole(Role role);

    @Select("select * from Role where id=#{id}")
    Role findRoleById(@Param("id") Integer id);

    @Select("select * from Role ")
    List<Role> findAllRole();

    @Delete("delete from Role where id=#{id}")
    int deleteRoleByid(@Param("id") Integer id);
}

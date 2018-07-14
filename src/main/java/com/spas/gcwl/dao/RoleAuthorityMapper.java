package com.spas.gcwl.dao;



import com.spas.gcwl.entity.RoleAuthority;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleAuthorityMapper {

    @Insert("insert into RoleAuthority(id,Role_id) values(#{id},#{Role_id}) ")
    int addRoleAuthority(RoleAuthority roleAuthority);

    @Select("select id from RoleAuthority where Role_id=#{Role_id}")
    List<Integer> findAuthorityByRoleId(@Param("Role_id") Integer Role_id );

    @Delete("delete from RoleAuthority where id=#{id} and Role_id=#{Role_id}")
    int deleteColums(RoleAuthority roleAuthority);

    @Delete("delete from RoleAuthority where  Role_id=#{Role_id}")
    int deleteByRoleId(@Param("Role_id") Integer Role_id);
}

package com.spas.gcwl.dao;

import com.spas.gcwl.entity.UserRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserRoleMapper {
    @Insert("insert into UserRole(userme,id) values(#{userme},#{id})")
    int addUserRole(UserRole userRole);

    @Select("select id from UserRole where userme=#{userme}")
    List<Integer> findIdByUserme(@Param("userme") String userme);

    @Delete("delete from UserRole where userme=#{userme}")
    int deleteALlRoleByName(@Param("userme") String userme);

    //modification
}

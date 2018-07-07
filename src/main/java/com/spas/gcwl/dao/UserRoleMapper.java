package com.spas.gcwl.dao;

import com.spas.gcwl.entity.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserRoleMapper {
    @Insert("insert into UserRole(userme,id) values(#{userme},#{id})")
    int insertUserRole(UserRole userRole);

    @Select("select id from UserRole where userme=#{userme}")
    int selectIdByUserme(String userme);

    //modification
}

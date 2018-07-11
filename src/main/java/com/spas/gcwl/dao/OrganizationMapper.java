package com.spas.gcwl.dao;


import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spas.gcwl.entity.Organization;

import java.util.List;

@Component
@Mapper
public interface OrganizationMapper {

    @Insert("insert into Organization(name,phone,address) values(#{name},#{phone},#{address})")
    int insertOrganization(Organization organization);

    @Select("select * from Organization ")
    List<Organization> findAllOrganization();

    @Select("select * from Organization where id=#{id}")
    Organization findOrganizationById(@Param("id") Integer id);

    @Update("update Organization set phone=#{phone},address=#{address} where id=#{id}")
    int updateInfoById(Organization organization);

    @Delete("delete from Organization where name=#{name}")
    int deleteOrganizationByName(@Param("name") String name);

}

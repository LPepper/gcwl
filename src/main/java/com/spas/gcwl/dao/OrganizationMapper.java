package com.spas.gcwl.dao;


import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spas.gcwl.entity.Organization;

@Component
@Mapper
public interface OrganizationMapper {

    @Insert("insert into Organization(name,phone,address) values(#{name},#{phone},#{address})")
    int insertOrganization(Organization organization);

}

package com.spas.gcwl.dao;

import com.spas.gcwl.entity.ProjectACar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectACarMapper {
    @Insert("insert into ProjectACar(number,project_id) values(#{number},#{project_id})")
    int addProjectACar(ProjectACar projectACar);
    @Select("select number from ProjectACar where project_id=#{project_id}")
    List<String> findNumberByProject_id(Integer project_id);
    @Select("select project_id from ProjectACar where number=#{number}")
    int findProject_idByNumber(String number);
}

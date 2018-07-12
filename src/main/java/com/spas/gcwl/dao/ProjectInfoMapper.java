package com.spas.gcwl.dao;

import com.spas.gcwl.entity.ProjectInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Mapper
public interface ProjectInfoMapper {
    @Insert("insert into ProjectInfo(userme,name,bdate,state,blocation,elocation,goods_info,phone) values(#{userme},#{name},#{bdate},#{state},#{blocation},#{elocation},#{goods_info},#{phone})")
    int submitProjectInfo(ProjectInfo projectInfo);

    @Select("select * from ProjectInfo where userme=#{userme}")
    List<ProjectInfo> findAllSubmittedProjectInfoByUserme(String userme);
    @Select("select * from ProjectInfo where state='submitted'")
    List<ProjectInfo> findAllSubmittedProjectInfo();
    @Select("select * from ProjectInfo where handler_username=#{handler_username}")
    List<ProjectInfo> findAllProcessedProjectInfoByHandler(String handler_username);
    @Select("select * from ProjectInfo where project_id=#{project_id}")
    ProjectInfo findProjectInfoById(Integer project_id);

    @Update("update ProjectInfo set offer=#{offer},state=#{state},handler_username=#{handler_username} where project_id=#{project_id}")
    int processSubmittedProjectInfoById(ProjectInfo projectInfo);


    @Update("update ProjectInfo set state='reprocess' where project_id=#{project_id}")
    int repocessProjectInfoById(Integer project_id);
    @Update("update ProjectInfo set state='processing' where project_id=#{project_id}")
    int processingProjectInfoById(Integer project_id);
    @Update("update ProjectInfo set state=#{state},edate=#{edate} where project_id=#{project_id}")
    int commitProjectInfoById(ProjectInfo projectInfo);

    @Delete("delete from ProjectInfo where project_id=#{project_id}")
    int deleteProjecctInfoById(Integer project_id);
}

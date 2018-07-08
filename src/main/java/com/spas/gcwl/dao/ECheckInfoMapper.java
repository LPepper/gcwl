package com.spas.gcwl.dao;


import com.spas.gcwl.entity.ECheckInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ECheckInfoMapper {
    @Insert("insert into ECheckInfo(number,p_number,carload,height,box_check,light_check,tyre_check,belt_check,fire_extinguisher_check,notice_board_check,recorder_check,reflecting_mark_check,protection_check,hammer_check,auto_fire_ex_check,car_mark_check,other,type,date) " +
            "values(#{number},#{p_number},#{carload},#{height},#{box_check},#{light_check},#{tyre_check},#{belt_check},#{fire_extinguisher_check},#{notice_board_check},#{recorder_check},#{reflecting_mark_check},#{protection_check},#{hammer_check},#{auto_fire_ex_check},#{car_mark_check},#{other},#{type},#{date})")
    int addECheckInfo(ECheckInfo eCheckInfo);

    @Select("select number,p_number,carload,height,box_check,light_check,tyre_check,belt_check,fire_extinguisher_check,notice_board_check,recorder_check,reflecting_mark_check,protection_check,hammer_check,auto_fire_ex_check,car_mark_check,other,type,date from ECheckInfo " +
            "where number=#{number} and type=#{type}")
    List<ECheckInfo> findByCarNumAndType(@Param("number") String number,@Param("type")Integer type);
}

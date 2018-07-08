package com.spas.gcwl.dao;



import com.spas.gcwl.entity.TechCheckInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TeckCheckInfoMapper {

    @Insert("insert into TechCheckInfo(number,steer_check,transmission_check,brake_check,dash_board_check,other,date,type) values(#{number},#{steer_check},#{transmission_check},#{brake_check},#{dash_board_check},#{other},#{date},#{type})")
    int addTeckCheckInfo(TechCheckInfo techCheckInfo);

    @Select("Select number,steer_check,transmission_check,brake_check,dash_board_check,other,date,type from TechCheckInfo where number=#{number} and type=#{type} ")
    List<TechCheckInfo> findByCarNumAndType(@Param("number") String number, @Param("type") Integer type);

}

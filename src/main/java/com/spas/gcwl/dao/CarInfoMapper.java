package com.spas.gcwl.dao;



import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.spas.gcwl.entity.CarInfo;

import java.util.List;

@Component
@Mapper
public interface CarInfoMapper {


    @Insert("insert into Carinfo(number,type,length,width,height,carload,location,belong,price,price_per_day,state,pic_url) values(#{number},#{type},#{length},#{width},#{height},#{carload},#{location},#{belong},#{price},#{price_per_day},#{state},#{pic_url}) ")
    int addCarInfo(CarInfo carInfo);

    @Select("select * from Carinfo")
    List<CarInfo> findAllCarInfo();

    @Select("select * from Carinfo where state='空闲'")
    List<CarInfo> findFreeCars();

    @Select("select * from Carinfo where number=#{number}")
    CarInfo findCarByNumber(@Param("number") String number);

    @Select("select * from Carinfo where id=#{id}")
    CarInfo findCarById(@Param("id") Integer id);

    @Delete("delete from Carinfo where number=#{number}")
    int deleteCarByNumber(@Param("number") String number);

    @Delete("delete from Carinfo where id=#{id}")
    int deleteCarById(@Param("id") Integer id);

    @Update("update Carinfo set state=#{state} where number=#{number}")
    int updateCarState(@Param("state") String state,@Param("number")String number);

    @Update("update Carinfo set location=#{location} where number=#{number}")
    int updateCarLocation(@Param("location") String location,@Param("number")String number);

    @Update("update Carinfo set number=#{number},type=#{type},length=#{length},width=#{width},height=#{height},carload=#{carload},belong=#{belong},price=#{price},price_per_day=#{price_per_day},state=#{state},location=#{location},pic_url=#{pic_url} where id=#{id}")
    int updateAllInfo(CarInfo carInfo);






}

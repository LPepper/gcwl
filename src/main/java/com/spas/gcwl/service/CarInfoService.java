package com.spas.gcwl.service;

import com.spas.gcwl.entity.CarInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarInfoService {
    int addCarInfo(CarInfo carInfo);
    List<CarInfo> findAllCarInfo();
    List<CarInfo> findFreeCars();
    List<CarInfo> findSelectedCars();
    CarInfo findCarByNumber( String number);
    int deleteCarByNumber( String number);
    int updateCarState( String state,String number);
    int updateCarLocation( String location,String number);
    int updateAllInfo(CarInfo carInfo);
    CarInfo findCarById( Integer id);
    int deleteCarById(Integer id);
    int updateToFreeByNumber(String number);
    int updateToUseByNumber(String number);
    int updateToFixByNumber(String number);
    String findCarStateByNumber(String number);


}

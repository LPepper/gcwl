package com.spas.gcwl.service.impl;


import com.spas.gcwl.dao.CarInfoMapper;
import com.spas.gcwl.entity.CarInfo;
import com.spas.gcwl.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInfoSeiviceImpl implements CarInfoService {
    @Autowired
    CarInfoMapper carInfoMapper;

    @Override
    public int addCarInfo(CarInfo carInfo){
        return this.carInfoMapper.addCarInfo(carInfo);
    }

    @Override
    public List<CarInfo> findAllCarInfo(){
        return this.carInfoMapper.findAllCarInfo();
    }

    @Override
    public CarInfo findCarByNumber( String number){
        return this.carInfoMapper.findCarByNumber(number);
    }

    @Override
    public int deleteCarByNumber( String number){
        return this.carInfoMapper.deleteCarByNumber(number);
    }

    @Override
    public int updateCarState( String state,String number){
        return this.carInfoMapper.updateCarState(state,number);
    }

    @Override
    public int updateCarLocation( String location,String number){
        return this.carInfoMapper.updateCarLocation(location,number);
    }

    @Override
    public int deleteCarById(Integer id) {
        return this.carInfoMapper.deleteCarById(id);
    }

    @Override
    public CarInfo findCarById(Integer id) {
        return this.carInfoMapper.findCarById(id);
    }

    @Override
    public int updateAllInfo(CarInfo carInfo){
        return this.carInfoMapper.updateAllInfo(carInfo);
    }


    @Override
    public List<CarInfo> findFreeCars() {
        return carInfoMapper.findFreeCars();
    }

    @Override
    public List<CarInfo> findSelectedCars() {
        return carInfoMapper.findSelectedCars();
    }

    @Override
    public int updateToFreeByNumber(String number) {
        return carInfoMapper.updateToFreeByNumber(number);
    }

    @Override
    public int updateToUseByNumber(String number) {
        return carInfoMapper.updateToUseByNumber(number);
    }

    @Override
    public int updateToFixByNumber(String number) {
        return carInfoMapper.updateToFixByNumber(number);
    }
}

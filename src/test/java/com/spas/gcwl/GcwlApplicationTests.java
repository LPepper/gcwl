package com.spas.gcwl;

import com.spas.gcwl.dao.*;
import com.spas.gcwl.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcwlApplicationTests {

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CarInfoMapper carInfoMapper;

    @Autowired
    TeckCheckInfoMapper teckCheckInfoMapper;

    @Autowired
    ECheckInfoMapper eCheckInfoMapper;


    @Test
    public void contextLoads() {
    }


    @Test
    @Transactional
    public void userMapperTest(){
        User user=new User("user2","123456","123456","重庆分公司","/pic.jpg");

        System.out.println(userMapper.insertUser(user));

        List<User> users= userMapper.findAllUser();
        User user1=userMapper.findByName("user1");

        userMapper.updateUserPassword(user);
        this.userMapper.updateUserInfoExceptPassword(user);
        System.out.println(user1.getPassword());
    }

    @Test
    @Transactional
    public void organizationMapperTest(){
        Organization organization=new Organization("成都分公司","123456","成都");

        organizationMapper.insertOrganization(organization);

        List<Organization> organizations=organizationMapper.findAllOrganization();
        System.out.println(organizations.size());

        this.organizationMapper.deleteOrganizationByName("成都分公司");
    }

    @Test
    @Transactional
    public void carinfoMapperTest(){
        CarInfo carInfo=new CarInfo("川A12346","高栏车",Float.parseFloat("6"),Float.parseFloat("2"),Float.parseFloat("3"),Float.parseFloat("10"),"重庆","四川",Float.parseFloat("30"),Float.parseFloat("3000"),"空闲");
        this.carInfoMapper.addCarInfo(carInfo);
        List<CarInfo> carInfos=this.carInfoMapper.findAllCarInfo();
        CarInfo carInfo1=this.carInfoMapper.findCarByNumber("川A12345");

        this.carInfoMapper.updateAllInfo(carInfo);
        this.carInfoMapper.updateCarLocation("四川","川A12345");
        this.carInfoMapper.updateCarState("维修","川A12345");

        this.carInfoMapper.deleteCarByNumber("川A12345");
    }

    @Test
    @Transactional
    public void teckCheckInfoMapperTest(){
        Integer type=1;
        java.sql.Date date_sql = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date_sql);
        TechCheckInfo techCheckInfo=new TechCheckInfo("川A123","a","a","a","a","a",date_sql,type);
        this.teckCheckInfoMapper.addTeckCheckInfo(techCheckInfo);

        List<TechCheckInfo> techCheckInfos= this.teckCheckInfoMapper.findByCarNumAndType("川A123",type);
        System.out.println(techCheckInfos.size());
    }

    @Test
    @Transactional
    public void ECheckInfoMapperTest(){
        Integer type=1;
        Float testfloat=1.23f;
        java.sql.Date date_sql = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date_sql);

        ECheckInfo eCheckInfo=new ECheckInfo("川A123",2,testfloat,testfloat,"a","a","a","a","a","a","a","a","a","a","a","a","a",type,date_sql);
        this.eCheckInfoMapper.addECheckInfo(eCheckInfo);

        List<ECheckInfo> eCheckInfos=this.eCheckInfoMapper.findByCarNumAndType("川A123",type);
        System.out.println(eCheckInfos.size());



    }



}

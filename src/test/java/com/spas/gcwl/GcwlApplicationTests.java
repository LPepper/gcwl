package com.spas.gcwl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.spas.gcwl.entity.User;
import com.spas.gcwl.entity.Organization;
import com.spas.gcwl.dao.UserMapper;
import com.spas.gcwl.dao.OrganizationMapper;

import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcwlApplicationTests {

    @Autowired
    OrganizationMapper organizationMapper;
    UserMapper userMapper;


    @Test
    public void contextLoads() {
    }

    /*@Test
    @Transactional
    public void userMapperTest(){
        User user=new User("user1","123456","123456","sapa");
        System.out.println(userMapper.insertUser(user));
    }*/

    @Test
    @Transactional
    public void organizationMapperTest(){
        Organization organization=new Organization("chongqing","123456","chongqing");

        organizationMapper.insertOrganization(organization);
    }



}

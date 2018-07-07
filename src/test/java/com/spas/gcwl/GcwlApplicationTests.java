package com.spas.gcwl;

import com.spas.gcwl.dao.AuthorityMapper;
import com.spas.gcwl.dao.UserRoleMapper;
import com.spas.gcwl.entity.Authority;
import com.spas.gcwl.entity.UserRole;
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

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GcwlApplicationTests {

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    UserMapper userMapper;


    @Test
    public void contextLoads() {
    }

    /*
    @Test
    @Transactional
    public void userMapperTest(){
        User user=new User("user1","123456","123456","重庆分公司");
        System.out.println(userMapper.insertUser(user));
    }*/

    /*@Test
    @Transactional
    public void organizationMapperTest(){
        Organization organization=new Organization("重庆分公司","123456","重庆");

        organizationMapper.insertOrganization(organization);

        List<Organization> organizations=organizationMapper.findAllOrganization();
        System.out.println(organizations.size());
    }*/

/*    @Autowired
    AuthorityMapper authorityMapper;
    @Test
    @Transactional
    public  void AuthorityMapperTest(){
        Authority authority = new Authority(2,"2");

        authorityMapper.InsertAuthority(authority);

        authorityMapper.findAuthorityById(1);
    }*/

/*    @Autowired
    UserRoleMapper userRoleMapper;
    @Test
    @Transactional
    public  void UserRoleTest(){
        UserRole userRole = new UserRole("123",1);
        userRoleMapper.insertUserRole(userRole);
        userRoleMapper.selectIdByUserme("123");
    }*/



}

package com.spas.gcwl;

import com.spas.gcwl.dao.*;
import com.spas.gcwl.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.SQLOutput;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GcwlApplicationTests {

   // Logger logger=LoggerFactory.getLogger(this.getClass());
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

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    UserRoleMapper userRoleMapper;


    @Test
    public void contextLoads() {
    }


/*    @Test
    @Transactional
    public void userMapperTest(){
        User user=new User("user2","123456","123456","重庆分公司","/pic.jpg");

        System.out.println(userMapper.insertUser(user));

        List<User> users= userMapper.findAllUser();
        User user1=userMapper.findByName("user1");

        userMapper.updateUserPassword(user);
        this.userMapper.updateUserInfoExceptPassword(user);
        this.userMapper.deleteUser("user2");
        System.out.println(user1.getPassword());
    }

    @Test
    @Transactional
    public void organizationMapperTest(){
        Organization organization=new Organization("成都分公司","123456","成都");

        organizationMapper.insertOrganization(organization);

        List<Organization> organizations=organizationMapper.findAllOrganization();
        //logger.debug(organizationMapper.findAllOrganization().toString());
        Integer id=1;
        Organization organization1=this.organizationMapper.findOrganizationById(id);
        this.organizationMapper.deleteOrganizationByName("成都分公司");
        this.organizationMapper.deleteOrganizationById(id);
    }*/

    @Test
    @Transactional
    public void carinfoMapperTest(){
        CarInfo carInfo=new CarInfo("川A12346","高栏车",Float.parseFloat("6"),Float.parseFloat("2"),Float.parseFloat("3"),Float.parseFloat("10"),"重庆","四川",Float.parseFloat("30"),Float.parseFloat("3000"),"空闲","url");
        this.carInfoMapper.addCarInfo(carInfo);
        List<CarInfo> carInfos=this.carInfoMapper.findAllCarInfo();
        CarInfo carInfo1=this.carInfoMapper.findCarByNumber("川A12345");

        this.carInfoMapper.updateAllInfo(carInfo);
        this.carInfoMapper.updateCarLocation("四川","川A12345");
        this.carInfoMapper.updateCarState("维修","川A12345");

        this.carInfoMapper.deleteCarByNumber("川A12345");
        this.carInfoMapper.findFreeCars();
        this.carInfoMapper.findSelectedCars();
    }

/*    @Test
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


    @Test
    @Transactional
    public void RoleMapperTest(){
        Integer id=1;
        Role role=new Role("系统管理员","管理用户资料");

        this.roleMapper.addRole(role);
        List<Role> roles=this.roleMapper.findAllRole();
        System.out.println(roles.size());
        Role role1=this.roleMapper.findRoleById(id);
        //System.out.println(role1.getRole_name());
        this.roleMapper.deleteRoleByid(id);
        Integer i=this.roleMapper.findIdByName("系统管理员");
        roles=this.roleMapper.findAllRole();
        System.out.println(roles.size());


    }

    @Test
    @Transactional
    public void RoleAuthorityMapper(){
        Integer id=1;
        Integer role_id=2;

        RoleAuthority roleAuthority=new RoleAuthority(id,role_id);

        this.roleAuthorityMapper.addRoleAuthority(roleAuthority);
        Integer selectid= this.roleAuthorityMapper.findAuthorityByRoleId(2);
        System.out.println(selectid.toString());

        this.roleAuthorityMapper.deleteColums(roleAuthority);


    }

    @Test
    @Transactional
    public void UserRoleMapperTest(){
        Integer id=1;
        UserRole userRole=new UserRole("user2",id);
        this.userRoleMapper.addUserRole(userRole);
        List<Integer> integers=this.userRoleMapper.findIdByUserme("user2");
        System.out.println(integers.size());

    }*/
 /*   @Autowired
    ProjectInfoMapper projectInfoMapper;
    @Test
    @Transactional
    public void ProjectInfoTest(){
        Date date=new Date(System.currentTimeMillis());
        ProjectInfo projectInfo1=new ProjectInfo("123","123",date,"submitted","123","456","123","123");
        ProjectInfo projectInfo2=new ProjectInfo(1,Float.parseFloat("123"),"processed","123456");
        ProjectInfo projectInfo3=new ProjectInfo(1,date,"committed");

        projectInfoMapper.submitProjectInfo(projectInfo1);
        projectInfoMapper.findAllSubmittedProjectInfoByUserme("123");
        projectInfoMapper.findAllSubmittedProjectInfo();
        projectInfoMapper.processSubmittedProjectInfoById(projectInfo2);
        projectInfoMapper.findAllSubmittedProjectInfo();
        projectInfoMapper.findAllProcessedProjectInfoByHandler("123456");
        projectInfoMapper.findProjectInfoById(1);
        projectInfoMapper.processingProjectInfoById(1);
        projectInfoMapper.repocessProjectInfoById(1);
    }*/

}

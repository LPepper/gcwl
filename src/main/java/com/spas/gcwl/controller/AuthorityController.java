package com.spas.gcwl.controller;

import com.spas.gcwl.entity.Role;
import com.spas.gcwl.entity.User;
import com.spas.gcwl.service.impl.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorityController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserRoleServiceImpl userRoleService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    RoleAuthorityServiceImpl roleAuthorityService;

    @Autowired
    AuthorityServiceImpl authorityService;

    @RequestMapping(value = "/getAuthorities")
    @ResponseBody
    public List<String> getAuthorities(){
        System.out.println("开始获取用户权限");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.println("获取权限 用户名"+username);
        List<String> AuthoritiesList=new ArrayList<String>();

        //获得该用户角色
        List<Integer> rids = this.userRoleService.findIdByUserme(username);


        //Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        for (Integer rid : rids) {
            Role role =this.roleService.findRoleById(rid);



            //添加权限
            List<Integer> aids=this.roleAuthorityService.findAuthorityByRoleId(rid);
            for (Integer aid:aids){
                String authorityName=this.authorityService.findAuthorityById(aid);
                System.out.println("获取权限  "+authorityName);
                AuthoritiesList.add(authorityName);
            }

        }


        return AuthoritiesList;
    }

    @RequestMapping(value = "/getUsername")
    @ResponseBody
    public String getUsername(){
        System.out.println("--获取用户名信息--");
        String username = (String) SecurityUtils.getSubject().getPrincipal();

        return username;


    }
    @RequestMapping(value = "/getuserpicurl")
    @ResponseBody
    public String getuserpicurl(){
        System.out.println("--获取用户头像路径--");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        User user=this.userService.findByName(username);

        return "/"+user.getPic_url();


    }
}

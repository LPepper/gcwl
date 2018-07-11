package com.spas.gcwl.controller.Role;

import com.spas.gcwl.entity.Authority;
import com.spas.gcwl.entity.Role;
import com.spas.gcwl.entity.RoleAuthority;
import com.spas.gcwl.service.impl.AuthorityServiceImpl;
import com.spas.gcwl.service.impl.RoleAuthorityServiceImpl;
import com.spas.gcwl.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    RoleAuthorityServiceImpl roleAuthorityService;

    @Autowired
    AuthorityServiceImpl authorityService;

    @GetMapping("/list")
    public ModelAndView showlist(){

        List<Role> roleList=this.roleService.findAllRole();
        ModelAndView modelAndView=new ModelAndView("role_list");
        modelAndView.addObject("rolelist",roleList);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage(){

        List<Authority> authorityList=this.authorityService.findAllAuthority();
        ModelAndView modelAndView=new ModelAndView("role_add");
        modelAndView.addObject("authorityList",authorityList);

        return modelAndView;
    }

    //增加角色
    @PostMapping("/add")
    public ModelAndView add(Role role){

        this.roleService.addRole(role);
        Integer rid=this.roleService.findIdByName(role.getRole_name());
        Set<String> authorities=role.getAuthorities();

        for(String i:authorities){
            Integer aid=this.authorityService.findIdByTage(i);
            RoleAuthority roleAuthority=new RoleAuthority(aid,rid);

            this.roleAuthorityService.addRoleAuthority(roleAuthority);
        }

        ModelAndView modelAndView=new ModelAndView("role_add");

        return modelAndView;
    }

    //删除角色
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        Integer rid=Integer.valueOf(id );
        this.roleService.deleteRoleByid(rid);
        this.roleAuthorityService.deleteByRoleId(rid);

        ModelAndView modelAndView=new ModelAndView("forward:/role/list");
        return modelAndView;
    }

}

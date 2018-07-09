package com.spas.gcwl.controller.admin;


import com.spas.gcwl.entity.User;
import com.spas.gcwl.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServiceImpl userService;

    //TODO
    @RequestMapping("/add")
    public ModelAndView addAdmin(){


        ModelAndView modelAndView=new ModelAndView("admin_add");
        return modelAndView;
    }

    //TODO
    @RequestMapping("/detail")
    public ModelAndView showDetail(){


        ModelAndView modelAndView=new ModelAndView("admin_detail");
        return modelAndView;
    }


    @RequestMapping("/list")
    public ModelAndView showList(){

        List<User> users=this.userService.findAllUser();

        ModelAndView modelAndView=new ModelAndView("admin_list");
        modelAndView.addObject("userlist",users);
        return modelAndView;
    }


}

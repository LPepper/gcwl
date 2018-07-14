package com.spas.gcwl.controller.login;


import com.spas.gcwl.entity.User;
import com.spas.gcwl.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView=new ModelAndView("page-login");
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(String username, String password, HttpSession session){

        ModelAndView modelAndView=new ModelAndView("page-login");

//        User user=this.userService.findByName(username);
//
//        if(user!=null){
//            if(password.equals(user.getPassword())){
//
//                //设置session
//                session.setAttribute("username",username);
//                ModelAndView modelAndView2=new ModelAndView("forward:/all/com");
//                return modelAndView2;
//            }
//            else{
//                System.out.println("密码不正确");
//                return modelAndView;
//            }
//
//        }else{
//            System.out.println("用户名不存在");
//            return modelAndView;
//        }

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆

        try {
            subject.login(token);
            session.setAttribute("username",username);
            ModelAndView modelAndView2=new ModelAndView("forward:/all/com");
               return modelAndView2;
        }catch (Exception e){
            return modelAndView;
        }




    }
}

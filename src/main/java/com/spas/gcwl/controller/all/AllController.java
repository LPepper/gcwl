package com.spas.gcwl.controller.all;


import com.spas.gcwl.entity.Role;
import com.spas.gcwl.entity.User;
import com.spas.gcwl.entity.UserRole;
import com.spas.gcwl.service.impl.RoleServiceImpl;
import com.spas.gcwl.service.impl.UserRoleServiceImpl;
import com.spas.gcwl.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/all")
public class AllController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    UserRoleServiceImpl userRoleService;

    @Value("${web.upload-path}")
    private String webUploadPath;

    @RequestMapping("/com")
    public ModelAndView com(HttpSession session){

        //测试sesion
        Object username=session.getAttribute("username");
        if(username instanceof String){
            System.out.println(username);
        }
        ModelAndView modelAndView=new ModelAndView("all_com");
        return modelAndView;
    }
    @GetMapping("/pswmodification/{username}")
    public ModelAndView pswmodificationPage(){
        ModelAndView modelAndView=new ModelAndView("all_pswmodification");
        return modelAndView;
    }


    @GetMapping("/selfinfo")
    public ModelAndView selfinfo(HttpSession session){
        ModelAndView modelAndView=new ModelAndView("all_selfinfo");

        Object username=session.getAttribute("username");
        if(username instanceof String){


             User user =this.userService.findByName(username.toString());

             //获取用户角色
             String rolename="";
             List<Integer> roleIdList=this.userRoleService.findIdByUserme(username.toString());
             for(Integer roleId:roleIdList){
                 Role role =this.roleService.findRoleById(roleId);
                 rolename+=role.getRole_name();
                 rolename+=" ";
             }
            System.out.println(rolename);


             modelAndView.addObject("user",user);
             modelAndView.addObject("rolename",rolename);
             return modelAndView;

        }

        return modelAndView;
    }

    @PostMapping("/selfinfo")
    public ModelAndView selfinfoPost(HttpSession session,String phone,@RequestParam("file") MultipartFile file){
        ModelAndView modelAndView=new ModelAndView("all_selfinfo");

        Object username=session.getAttribute("username");
        if(username instanceof String){


            User user =this.userService.findByName(username.toString());

            //获取用户角色
            String rolename="";
            List<Integer> roleIdList=this.userRoleService.findIdByUserme(username.toString());
            for(Integer roleId:roleIdList){
                Role role =this.roleService.findRoleById(roleId);
                rolename+=role.getRole_name();
                rolename+=" ";
            }
            System.out.println(rolename);


            //更改信息
            user.setPhone(phone);



            modelAndView.addObject("user",user);
            modelAndView.addObject("rolename",rolename);


            //上传图片
            if (!file.isEmpty()) {
                if (file.getContentType().contains("image")) {
                    try {
                        String temp = "images" + File.separator;
                        // 获取图片的文件名
                        String fileName = file.getOriginalFilename();
                        System.out.println("文件名"+fileName);
                        // 获取图片的扩展名
                        String extensionName = StringUtils.substringAfter(fileName, ".");
                        System.out.println("扩展名"+extensionName);
                        // 新的图片文件名 = 获取时间戳+"."图片扩展名
                        String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
                        System.out.println("新文件名"+newFileName);
                        // 数据库保存的目录
                        String datdDirectory = temp.concat(String.valueOf(user.getUsername())).concat(File.separator);
                        System.out.println("数据库保存路径"+datdDirectory);
                        // 文件路径
                        String filePath = webUploadPath.concat(datdDirectory);
                        user.setPic_url(datdDirectory+newFileName);
                        System.out.println("文件路径"+filePath);

                        File dest = new File(filePath, newFileName);
                        if (!dest.getParentFile().exists()) {
                            dest.getParentFile().mkdirs();
                        }



                        // 删除旧头像
                        //TODO

                        // 上传到指定目录
                        file.transferTo(dest);


                        //更新用户信息
                        this.userService.updateUserInfoExceptPassword(user);


                        System.out.println("上传成功!");
                    } catch (IOException e) {
                        //resultVo.setError(0, "上传失败!");
                        System.out.println("上传失败!");

                    }
                } else {
                    //resultVo.setError(0, "上传的文件不是图片类型，请重新上传!");
                    System.out.println("上传的文件不是图片类型，请重新上传!!");
                }
                return modelAndView;
            } else {
                //resultVo.setError(0, "上传失败，请选择要上传的图片!");
                System.out.println("上传失败，请选择要上传的图片!!");
                return modelAndView;
            }

        }

        return modelAndView;
    }


    @PostMapping("/pswmodification/{username}")
    public ModelAndView pswmodification(@PathVariable("username") String username, String oldpassword, String newpassword, String renewpassword){

        ModelAndView modelAndView=new ModelAndView("all_pswmodification");

        User user=this.userService.findByName(username);
        if(oldpassword.equals(user.getPassword())){
            if(newpassword.equals(renewpassword)){
                user.setPassword(newpassword);
                this.userService.updateUserPassword(user);
                System.out.println("修改成功");
                return modelAndView;
            }else {
                System.out.println("密码不一致");
                return modelAndView;
            }
        }else {
            System.out.println("原密码错误");
            return modelAndView;
        }



    }
}

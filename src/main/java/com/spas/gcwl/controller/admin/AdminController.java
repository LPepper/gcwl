package com.spas.gcwl.controller.admin;


import com.spas.gcwl.entity.Organization;
import com.spas.gcwl.entity.Role;
import com.spas.gcwl.entity.User;
import com.spas.gcwl.entity.UserRole;
import com.spas.gcwl.service.impl.OrganizationServiceImpl;
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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    OrganizationServiceImpl organizationService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    UserRoleServiceImpl userRoleService;

    @Value("${web.upload-path}")
    private String webUploadPath;

    //增加用户界面
    @GetMapping("/add")
    public ModelAndView addAdminPage(){

        List<Organization> organizations=this.organizationService.findAllOrganization();
        List<Role> roles=this.roleService.findAllRole();
        ModelAndView modelAndView=new ModelAndView("admin_add");
        modelAndView.addObject("organizations",organizations);
        modelAndView.addObject("roles",roles);
        return modelAndView;
    }

    //增加用户
    @PostMapping("/add")
    public ModelAndView addAdmin(User user,@RequestParam("file") MultipartFile file){

        user.setPassword("666666");

        List<Organization> organizations=this.organizationService.findAllOrganization();
        List<Role> roles=this.roleService.findAllRole();
        ModelAndView modelAndView=new ModelAndView("admin_add");
        modelAndView.addObject("organizations",organizations);
        modelAndView.addObject("roles",roles);

        //判断用户名是否存在
        User oldUser=this.userService.findByName(user.getUsername());
        if(oldUser!=null){
            System.out.println("该用户已存在");
            return modelAndView;
        }


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



                    // 判断是否有旧头像，如果有就先删除旧头像，再上传
                    /*SUser userInfo = sUserService.findUserInfo(userId.toString());
                    if (StringUtils.isNotBlank(userInfo.getUserHead())) {
                        String oldFilePath = webUploadPath.concat(userInfo.getUserHead());
                        File oldFile = new File(oldFilePath);
                        if (oldFile.exists()) {
                            oldFile.delete();
                        }
                    }*/
                    // 上传到指定目录
                    file.transferTo(dest);
                    this.userService.insertUser(user);

                    //分配用户权限
                    Set<String> roleSet=user.getRoles();
                    for(String role:roleSet){
                        Integer rid=this.roleService.findIdByName(role);
                        UserRole userRole=new UserRole(user.getUsername(),rid);
                        this.userRoleService.addUserRole(userRole);
                    }

                    // 将图片流转换进行BASE64加码
                    //BASE64Encoder encoder = new BASE64Encoder();
                    //String data = encoder.encode(file.getBytes());

                    // 将反斜杠转换为正斜杠
                    //String data = datdDirectory.replaceAll("\\\\", "/") + newFileName;
                    //Map<String, Object> resultMap = new HashMap<>();
                    //resultMap.put("file", data);
                    //resultVo.setData(resultMap);
                    //resultVo.setError(1, "上传成功!");
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


        //return modelAndView;
    }

    //用户信息页面
    @GetMapping("/detail/{username}")
    public ModelAndView showDetailPage(@PathVariable("username") String username){

        User user=this.userService.findByName(username);
        List<Organization> organizations=this.organizationService.findAllOrganization();
        List<Role> roles=this.roleService.findAllRole();


        ModelAndView modelAndView=new ModelAndView("admin_detail");
        modelAndView.addObject("organizations",organizations);
        modelAndView.addObject("roles",roles);
        modelAndView.addObject("username",username);
        modelAndView.addObject("phone",user.getPhone());
        modelAndView.addObject("picurl",user.getPic_url());
        return modelAndView;

    }

    //用户信息页面修改
    @PostMapping("/detail/{username}")
    public ModelAndView showDetail(@PathVariable("username") String username,User user,@RequestParam("file") MultipartFile file){
        user.setUsername(username);
        User user1=this.userService.findByName(username);
        List<Organization> organizations=this.organizationService.findAllOrganization();
        List<Role> roles=this.roleService.findAllRole();


        ModelAndView modelAndView=new ModelAndView("admin_detail");
        modelAndView.addObject("organizations",organizations);
        modelAndView.addObject("roles",roles);
        modelAndView.addObject("username",username);
        modelAndView.addObject("phone",user1.getPhone());
        modelAndView.addObject("picurl",user1.getPic_url());


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

                    //删除用户已有权限

                    this.userRoleService.deleteALlRoleByName(user.getUsername());

                    //分配用户权限
                    Set<String> roleSet=user.getRoles();

                    for(String role:roleSet){
                        Integer rid=this.roleService.findIdByName(role);
                        UserRole userRole=new UserRole(user.getUsername(),rid);
                        this.userRoleService.addUserRole(userRole);
                    }


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


    //用户列表页面
    @GetMapping("/list")
    public ModelAndView showList(){

        List<User> users=this.userService.findAllUser();

        ModelAndView modelAndView=new ModelAndView("admin_list");
        modelAndView.addObject("userlist",users);
        return modelAndView;
    }


    //删除用户
    @GetMapping("/delete/{username}")
    public ModelAndView deleteUser(@PathVariable("username") String username){
        this.userService.deleteUser(username);
        this.userRoleService.deleteALlRoleByName(username);

        ModelAndView mv = new ModelAndView("forward:/admin/list");//默认为forward模式
        return mv;

    }


}

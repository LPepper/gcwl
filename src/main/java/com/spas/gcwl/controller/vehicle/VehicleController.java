package com.spas.gcwl.controller.vehicle;

import com.spas.gcwl.entity.CarInfo;
import com.spas.gcwl.entity.ProjectInfo;
import com.spas.gcwl.entity.UserRole;
import com.spas.gcwl.service.CarInfoService;
import com.spas.gcwl.service.impl.CarInfoSeiviceImpl;
import com.spas.gcwl.service.impl.ProjectACarImpl;
import com.spas.gcwl.service.impl.ProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    CarInfoSeiviceImpl carInfoSeivice;

    @Autowired
    ProjectInfoServiceImpl projectInfoService;

    @Autowired
    ProjectACarImpl projectACar;

    @Value("${web.upload-path}")
    private String webUploadPath;


    @GetMapping("/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView=new ModelAndView("vehicle_add");


        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(CarInfo carInfo,String prefix,String suffix,String carTP,@RequestParam("file") MultipartFile file){


        ModelAndView modelAndView=new ModelAndView("vehicle_add");

        //设置车牌信息
        carInfo.setNumber(prefix+suffix);

        //判断车牌是否已存在
        CarInfo carInfo1=this.carInfoSeivice.findCarByNumber(prefix+suffix);
        if(carInfo1!=null){
            System.out.println("车辆已存在！");
            return modelAndView;
        }
        //设置车辆状态
        carInfo.setState("空闲");

        String []a=carTP.split("\\*");
        //设置长宽高信息
        if(a.length==3){
            carInfo.setLength(Float.parseFloat(a[0]));
            carInfo.setWidth(Float.parseFloat(a[1]));
            carInfo.setHeight(Float.parseFloat(a[2]));
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
                    String datdDirectory = temp.concat(String.valueOf(carInfo.getNumber())).concat(File.separator);
                    System.out.println("数据库保存路径"+datdDirectory);
                    // 文件路径
                    String filePath = webUploadPath.concat(datdDirectory);
                    carInfo.setPic_url(datdDirectory+newFileName);
                    System.out.println("文件路径"+filePath);

                    File dest = new File(filePath, newFileName);
                    if (!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdirs();
                    }



                    // 删除旧头像
                    //TODO

                    // 上传到指定目录
                    file.transferTo(dest);
                    //增加车辆
                    this.carInfoSeivice.addCarInfo(carInfo);




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


    //TODO
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") String id){

        ModelAndView modelAndView=new ModelAndView("vehicle_detail");
        //查找车辆
        Integer cid=Integer.valueOf(id);
        CarInfo carInfo=this.carInfoSeivice.findCarById(cid);
        System.out.println(carInfo.getNumber());
        //查找车辆相关订单物流信息
        List<Integer> proIds=this.projectACar.findProject_idByNumber(carInfo.getNumber());

        List<ProjectInfo> projectInfos=new ArrayList<ProjectInfo>();
        for(Integer i:proIds){
            projectInfos.add(this.projectInfoService.findProjectInfoById(i));
        }
        if(projectInfos.size()>0){
            modelAndView.addObject("projectInfos",projectInfos);
        }


        modelAndView.addObject("carInfo",carInfo);

        modelAndView.addObject("pic_url",carInfo.getPic_url());


        return modelAndView;
    }


    @GetMapping("/list")
    public ModelAndView showlist(){
        List<CarInfo> carInfos=this.carInfoSeivice.findAllCarInfo();
        ModelAndView modelAndView=new ModelAndView("vehicle_list");
        modelAndView.addObject("carInfos",carInfos);
        return modelAndView;
    }





    @GetMapping("/modification/{id}")
    public ModelAndView modificationPage(@PathVariable("id") String id){

        Integer cid=Integer.valueOf(id);
        CarInfo carInfo =this.carInfoSeivice.findCarById(cid);

        ModelAndView modelAndView=new ModelAndView("vehicle_modification");
        modelAndView.addObject("carInfo",carInfo);

        return modelAndView;
    }

    @PostMapping("/modification/{id}")
    public ModelAndView modification(@PathVariable("id") String id,CarInfo carInfo,String carTp,@RequestParam("file") MultipartFile file){

        Integer cid=Integer.valueOf(id);
        CarInfo preCarInfo =this.carInfoSeivice.findCarById(cid);
        carInfo.setId(cid);
        //设置车辆状态
        carInfo.setState("空闲");

        String []a=carTp.split("\\*");
        //设置长宽高信息
        if(a.length==3){
            carInfo.setLength(Float.parseFloat(a[0]));
            carInfo.setWidth(Float.parseFloat(a[1]));
            carInfo.setHeight(Float.parseFloat(a[2]));
        }

        ModelAndView modelAndView=new ModelAndView("vehicle_modification");
        modelAndView.addObject("carInfo",preCarInfo);

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
                    String datdDirectory = temp.concat(String.valueOf(carInfo.getNumber())).concat(File.separator);
                    System.out.println("数据库保存路径"+datdDirectory);
                    // 文件路径
                    String filePath = webUploadPath.concat(datdDirectory);

                    //设置车辆图片存储路径
                    carInfo.setPic_url(datdDirectory+newFileName);

                    System.out.println("文件路径"+filePath);


                    File dest = new File(filePath, newFileName);
                    if (!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdirs();
                    }



                    // 删除旧头像
                    //TODO

                    // 上传到指定目录
                    file.transferTo(dest);

                    System.out.println(carInfo.getId());
                    System.out.println(carInfo.getState());
                    System.out.println(carInfo.getNumber());
                    System.out.println(carInfo.getLength());
                    System.out.println(carInfo.getWidth());
                    System.out.println(carInfo.getHeight());
                    System.out.println(carInfo.getCarload());
                    System.out.println(carInfo.getLocation());
                    System.out.println(carInfo.getBelong());
                    System.out.println(carInfo.getPrice());
                    System.out.println(carInfo.getPrice_per_day());
                    System.out.println(carInfo.getPic_url());


                    //更新车辆信息
                    this.carInfoSeivice.updateAllInfo(carInfo);





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


    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){


        Integer carId=Integer.valueOf(id);
        this.carInfoSeivice.deleteCarById(carId);





        ModelAndView modelAndView=new ModelAndView("forward:/vehicle/list");

        return modelAndView;
    }



}

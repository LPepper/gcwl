package com.spas.gcwl.controller.examine;


import com.spas.gcwl.entity.*;
import com.spas.gcwl.service.ProjectACarService;
import com.spas.gcwl.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/examine")
public class ExamineController {

    @Autowired
    TeckCheckInfoServiceImpl teckCheckInfoService;
    @Autowired
    ECheckInfoServiceImpl eCheckInfoService;
    @Autowired
    CarInfoSeiviceImpl carInfoSeivice;
    @Autowired
    ProjectACarImpl projectACarService;
    @Autowired
    ProjectInfoServiceImpl projectInfoService;

    @RequestMapping("/in/list")
    public ModelAndView inList(){
        List<CarInfo> carInfos=carInfoSeivice.findFreeCars();
        ModelAndView modelAndView=new ModelAndView("examine_in_list");
        modelAndView.addObject("cars",carInfos);
        return modelAndView;
    }
    @RequestMapping("/out/list")
    public ModelAndView outList(){
        List<CarInfo> carInfos=carInfoSeivice.findSelectedCars();
        ModelAndView modelAndView=new ModelAndView("examine_out_list");
        modelAndView.addObject("cars",carInfos);
        return modelAndView;
    }


    @GetMapping("/in/add")
    public ModelAndView inAddPage()
    {
        ModelAndView modelAndView=new ModelAndView("examine_in_detail");
        return modelAndView;
    }
    @PostMapping("/in/add")
    public ModelAndView inAddT(TechCheckInfo techCheckInfo){
        ModelAndView modelAndView=new ModelAndView("redirect:/examine/in/add2");
        teckCheckInfoService.addTeckCheckInfo(techCheckInfo);
        if(!techCheckInfo.getBrake_check().equals("正常") || !techCheckInfo.getDash_board_check().equals("正常")|| !techCheckInfo.getSteer_check().equals("正常")|| !techCheckInfo.getTransmission_check().equals("正常"))
            carInfoSeivice.updateToFixByNumber(techCheckInfo.getNumber());
        ProjectInfo projectInfo=new ProjectInfo(projectACarService.findAProject_idByNumber(techCheckInfo.getNumber()),techCheckInfo.getDate(),"committed");
        projectInfoService.commitProjectInfoById(projectInfo);
        return modelAndView;
    }
    @GetMapping("/in/add2")
    public ModelAndView inAddPageE(){

        ModelAndView modelAndView=new ModelAndView("examine_in_detail2");
        return modelAndView;
    }
    @PostMapping("/in/add2")
    public ModelAndView inAddE(ECheckInfo eCheckInfo){
        ModelAndView modelAndView=new ModelAndView("examine_in_detail2");
        eCheckInfoService.addECheckInfo(eCheckInfo);
        if(!eCheckInfo.getAuto_fire_ex_check().equals("正常") || !eCheckInfo.getBelt_check().equals("正常") || !eCheckInfo.getBox_check().equals("正常") || !eCheckInfo.getCar_mark_check().equals("正常") || !eCheckInfo.getFire_extinguisher_check().equals("正常") || !eCheckInfo.getHammer_check().equals("正常")|| !eCheckInfo.getLight_check().equals("正常" )|| !eCheckInfo.getNotice_board_check().equals("正常")|| !eCheckInfo.getProtection_check().equals("正常")|| !eCheckInfo.getRecorder_check().equals("正常")|| !eCheckInfo.getReflecting_mark_check().equals("正常"))
            carInfoSeivice.updateToFixByNumber(eCheckInfo.getNumber());
        else carInfoSeivice.updateToFreeByNumber(eCheckInfo.getNumber());
        return modelAndView;
    }

    @RequestMapping("/out/add")
    public ModelAndView outAddPageT(){
        ModelAndView modelAndView=new ModelAndView("examine_out_detail");
        return modelAndView;
    }
    @PostMapping("/out/add")
    public ModelAndView outAddT(TechCheckInfo techCheckInfo){
        ModelAndView modelAndView=new ModelAndView("redirect:/examine/out/add2");
        if(!techCheckInfo.getBrake_check().equals("正常") || !techCheckInfo.getDash_board_check().equals("正常")|| !techCheckInfo.getSteer_check().equals("正常")|| !techCheckInfo.getTransmission_check().equals("正常")) carInfoSeivice.updateToFixByNumber(techCheckInfo.getNumber());
        teckCheckInfoService.addTeckCheckInfo(techCheckInfo);
        return modelAndView;
    }
    @GetMapping("/out/add2")
    public ModelAndView outAddPageE(){
        ModelAndView modelAndView=new ModelAndView("examine_out_detail2");
        return modelAndView;
    }

    @PostMapping("/out/add2")
    public ModelAndView outAddE(ECheckInfo eCheckInfo){
        ModelAndView modelAndView=new ModelAndView("examine_out_detail2");
        eCheckInfoService.addECheckInfo(eCheckInfo);
        if(!eCheckInfo.getAuto_fire_ex_check().equals("正常") || !eCheckInfo.getBelt_check().equals("正常") || !eCheckInfo.getBox_check().equals("正常") || !eCheckInfo.getCar_mark_check().equals("正常") || !eCheckInfo.getFire_extinguisher_check().equals("正常") || !eCheckInfo.getHammer_check().equals("正常")|| !eCheckInfo.getLight_check().equals("正常" )|| !eCheckInfo.getNotice_board_check().equals("正常")|| !eCheckInfo.getProtection_check().equals("正常")|| !eCheckInfo.getRecorder_check().equals("正常")|| !eCheckInfo.getReflecting_mark_check().equals("正常"))
            carInfoSeivice.updateToFixByNumber(eCheckInfo.getNumber());
        else carInfoSeivice.updateToUseByNumber(eCheckInfo.getNumber());
        if (carInfoSeivice.findCarStateByNumber(eCheckInfo.getNumber()).equals("维修")){
            ProjectInfo projectInfo=new ProjectInfo(projectACarService.findAProject_idByNumber(eCheckInfo.getNumber()),eCheckInfo.getDate(),"reprocess");
            projectInfoService.reprocessProjectInfoById(projectACarService.findAProject_idByNumber(eCheckInfo.getNumber()));
        }
        else{
            projectInfoService.processingProjectInfoById(projectACarService.findAProject_idByNumber(eCheckInfo.getNumber()));
        }
        return modelAndView;
    }



}

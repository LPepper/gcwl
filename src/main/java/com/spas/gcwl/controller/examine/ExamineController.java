package com.spas.gcwl.controller.examine;


import com.spas.gcwl.entity.CarInfo;
import com.spas.gcwl.entity.ECheckInfo;
import com.spas.gcwl.entity.TechCheckInfo;
import com.spas.gcwl.service.impl.CarInfoSeiviceImpl;
import com.spas.gcwl.service.impl.ECheckInfoServiceImpl;
import com.spas.gcwl.service.impl.TeckCheckInfoServiceImpl;
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


    @GetMapping("/in/add1")
    public ModelAndView inAddPage()
    {
        ModelAndView modelAndView=new ModelAndView("examine_in_detail");
        return modelAndView;
    }
    @PostMapping("/in/add1")
    public ModelAndView inAddT(TechCheckInfo techCheckInfo){
        ModelAndView modelAndView=new ModelAndView("forward:/examine/in/add2");
        teckCheckInfoService.addTeckCheckInfo(techCheckInfo);
        if(techCheckInfo.getBrake_check()!="正常" || techCheckInfo.getDash_board_check()!="正常"|| techCheckInfo.getSteer_check()!="正常"|| techCheckInfo.getTransmission_check()!="正常")
            carInfoSeivice.updateToFixByNumber(techCheckInfo.getNumber());
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
        if(eCheckInfo.getAuto_fire_ex_check()!="正常" || eCheckInfo.getBelt_check()!="正常" || eCheckInfo.getBox_check()!="正常" || eCheckInfo.getCar_mark_check()!="正常" || eCheckInfo.getFire_extinguisher_check()!="正常" || eCheckInfo.getHammer_check()!="正常"|| eCheckInfo.getLight_check()!="正常" || eCheckInfo.getNotice_board_check()!="正常"|| eCheckInfo.getProtection_check()!="正常"|| eCheckInfo.getRecorder_check()!="正常"|| eCheckInfo.getReflecting_mark_check()!="正常")
            carInfoSeivice.updateToFixByNumber(eCheckInfo.getNumber());
        carInfoSeivice.updateToFreeByNumber(eCheckInfo.getNumber());
        return modelAndView;
    }

    @RequestMapping("/out/add1")
    public ModelAndView outAddPageT(){
        ModelAndView modelAndView=new ModelAndView("examine_out_detail");
        return modelAndView;
    }
    @PostMapping("/out/add1")
    public ModelAndView outAddT(TechCheckInfo techCheckInfo){
        ModelAndView modelAndView=new ModelAndView("forward:/examine/out/add2");
        if(techCheckInfo.getBrake_check()!="正常" || techCheckInfo.getDash_board_check()!="正常"|| techCheckInfo.getSteer_check()!="正常"|| techCheckInfo.getTransmission_check()!="正常") carInfoSeivice.updateToFixByNumber(techCheckInfo.getNumber());
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
        if(eCheckInfo.getAuto_fire_ex_check()!="正常" || eCheckInfo.getBelt_check()!="正常" || eCheckInfo.getBox_check()!="正常" || eCheckInfo.getCar_mark_check()!="正常" || eCheckInfo.getFire_extinguisher_check()!="正常" || eCheckInfo.getHammer_check()!="正常"|| eCheckInfo.getLight_check()!="正常" || eCheckInfo.getNotice_board_check()!="正常"|| eCheckInfo.getProtection_check()!="正常"|| eCheckInfo.getRecorder_check()!="正常"|| eCheckInfo.getReflecting_mark_check()!="正常")
            carInfoSeivice.updateToFixByNumber(eCheckInfo.getNumber());
        carInfoSeivice.updateToUseByNumber(eCheckInfo.getNumber());
        return modelAndView;
    }



}

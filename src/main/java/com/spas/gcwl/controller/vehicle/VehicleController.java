package com.spas.gcwl.controller.vehicle;

import com.spas.gcwl.service.CarInfoService;
import com.spas.gcwl.service.impl.CarInfoSeiviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    CarInfoSeiviceImpl carInfoSeivice;


    //TODO
    @GetMapping("/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView=new ModelAndView("vehicle_add");


        return modelAndView;
    }


    //TODO
    @GetMapping("/detail")
    public ModelAndView detail(){

        ModelAndView modelAndView=new ModelAndView("vehicle_detail");

        return modelAndView;
    }
}

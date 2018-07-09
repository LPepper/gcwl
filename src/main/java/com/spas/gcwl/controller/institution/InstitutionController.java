package com.spas.gcwl.controller.institution;

import com.spas.gcwl.entity.Organization;
import com.spas.gcwl.service.impl.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/institution")
public class InstitutionController {

    @Autowired
    OrganizationServiceImpl organizationService;

    @RequestMapping("/list")
    public ModelAndView showlist(){
        List<Organization> organizations=this.organizationService.findAllOrganization();


        ModelAndView modelAndView=new ModelAndView("instutution_list");
        modelAndView.addObject("organizationlist",organizations);
        return modelAndView;
    }

    //TODO
    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request){

        //System.out.println(request.getParameter("orgname"));
        ModelAndView modelAndView=new ModelAndView("instutution_add");

        return modelAndView;
    }

    //TODO
    @RequestMapping("/modification")
    public ModelAndView modification(){


        ModelAndView modelAndView=new ModelAndView("instutution_modification");

        return modelAndView;
    }
}

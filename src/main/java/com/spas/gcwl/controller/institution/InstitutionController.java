package com.spas.gcwl.controller.institution;

import com.spas.gcwl.entity.Organization;
import com.spas.gcwl.service.impl.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


    @GetMapping("/add")
    public ModelAndView addpage(){

        //System.out.println(request.getParameter("orgname"));
        ModelAndView modelAndView=new ModelAndView("instutution_add");

        return modelAndView;
    }


    //增加机构 不建议使用request 而是使用类绑定参数
    @PostMapping("/add")
    public ModelAndView add(HttpServletRequest request){


        ModelAndView modelAndView=new ModelAndView("instutution_add");
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        //System.out.println(name+" "+phone+" "+address);

        Organization organization=new Organization(name,phone,address);
        this.organizationService.insertOrganization(organization);

        return modelAndView;
    }

    @GetMapping("/modification/{id}")
    public ModelAndView modificationPage(@PathVariable(value = "id") String id){

        Integer org_id=Integer.valueOf(id);
        System.out.println("org_id=  "+org_id);

        Organization organization=this.organizationService.findOrganizationById(org_id);

        ModelAndView modelAndView=new ModelAndView("instutution_modification");
        modelAndView.addObject("orgname",organization.getName());
        return modelAndView;
    }


    @PostMapping("/modification/{id}")
    public ModelAndView modification(@PathVariable(value = "id") String id,HttpServletRequest request){
        Integer org_id=Integer.valueOf(id);
        System.out.println("org_id=  "+org_id);

        Organization organization=this.organizationService.findOrganizationById(org_id);
        System.out.println(organization.getId()+" "+organization.getName()+" "+organization.getAddress()+" "+organization.getPhone());

        organization.setPhone(request.getParameter("phone"));
        organization.setAddress(request.getParameter("address"));

        this.organizationService.updateInfoById(organization);

        ModelAndView modelAndView=new ModelAndView("instutution_modification");
        modelAndView.addObject("orgname",organization.getName());


        return modelAndView;
    }
}

package com.spas.gcwl.controller.manager;

import com.spas.gcwl.entity.CarInfo;
import com.spas.gcwl.entity.ProjectACar;
import com.spas.gcwl.entity.ProjectInfo;
import com.spas.gcwl.service.ProjectACarService;
import com.spas.gcwl.service.impl.CarInfoSeiviceImpl;
import com.spas.gcwl.service.impl.ProjectACarImpl;
import com.spas.gcwl.service.impl.ProjectInfoServiceImpl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ProjectInfoServiceImpl projectInfoService;
    @Autowired
    CarInfoSeiviceImpl carInfoSeivice;
    @Autowired
    ProjectACarImpl projectACarService;

    @RequestMapping("/list")
    public ModelAndView showList(){
        List<ProjectInfo> submitprojectInfos=this.projectInfoService.findAllSubmittedProjectInfo();
        List<ProjectInfo> processedprojectInfos=this.projectInfoService.findProjectInfoByState("processed");
        List<ProjectInfo> processingprojectInfos=this.projectInfoService.findProjectInfoByState("processing");
        List<ProjectInfo> reprocessprojectInfos=this.projectInfoService.findProjectInfoByState("reprocess");
        List<ProjectInfo> comittedprojectInfos=this.projectInfoService.findProjectInfoByState("committed");
        ModelAndView modelAndView=new ModelAndView("manager_list");
        modelAndView.addObject("projectlist",submitprojectInfos);
        modelAndView.addObject("processed",processedprojectInfos);
        modelAndView.addObject("processing",processingprojectInfos);
        modelAndView.addObject("reprocess",reprocessprojectInfos);
        modelAndView.addObject("committed",comittedprojectInfos);

        return modelAndView;
    }

    @GetMapping("/detail/{project_id}")
    public ModelAndView showDetai(@PathVariable("project_id") Integer project_id){
        ModelAndView modelAndView=new ModelAndView("manager_detail");
        ProjectInfo projectInfo=this.projectInfoService.findProjectInfoById(project_id);
        modelAndView.addObject("detail",projectInfo);
        return modelAndView;
    }

    @GetMapping("/offer/{project_id}")
    public ModelAndView offerPage(@PathVariable("project_id") Integer project_id){
        ModelAndView modelAndView=new ModelAndView("manager_process");
        ProjectInfo detail=this.projectInfoService.findProjectInfoById(project_id);
        modelAndView.addObject("detail",detail);
        return modelAndView;
    }
    @PostMapping("/offer/{project_id}")
    public ModelAndView offer(ProjectInfo projectInfo,@PathVariable("project_id") Integer project_id){

        projectInfo.setProject_id(project_id);
        projectInfo.setState("processed");
        projectInfo.setHandler_username("123456");
        projectInfoService.processSubmittedProjectInfoById(projectInfo);

        ModelAndView modelAndView=new ModelAndView("forward:/manager/list");
        return  modelAndView;
    }

    @GetMapping("/offer2/{project_id}")
    public ModelAndView offer2Page(@PathVariable("project_id") Integer project_id){
        ModelAndView modelAndView=new ModelAndView("manager_process2");
        ProjectInfo detail=this.projectInfoService.findProjectInfoById(project_id);
        modelAndView.addObject("detail",detail);
        List<CarInfo> carInfos=this.carInfoSeivice.findFreeCars();
        modelAndView.addObject("cars",carInfos);
        return modelAndView;
    }
    @PostMapping("/offer2/{project_id}")
    public ModelAndView offer2(ProjectInfo projectInfo, String number, @PathVariable("project_id") Integer project_id){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        projectInfo.setProject_id(project_id);
        projectInfo.setState("processed");
        projectInfo.setHandler_username(username);
        projectInfoService.processSubmittedProjectInfoById(projectInfo);
        ProjectACar projectACar=new ProjectACar();
        projectACar.setNumber(number);
        projectACar.setProject_id(projectInfo.getProject_id());
        this.projectACarService.addProjectACar(projectACar);
        carInfoSeivice.updateCarState("选中",number);
        ModelAndView modelAndView=new ModelAndView("forward:/manager/list");
        return  modelAndView;
    }

    @GetMapping("/commit/{project_id}")
    public ModelAndView commit(@PathVariable("project_id") Integer project_id){
        ModelAndView modelAndView=new ModelAndView("forward:/manager/list");
        Date d=new Date(System.currentTimeMillis());
        ProjectInfo projectInfo=new ProjectInfo(project_id,d,"committed");
        projectInfoService.commitProjectInfoById(projectInfo);
        return modelAndView;
    }

}


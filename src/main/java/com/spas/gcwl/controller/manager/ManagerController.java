package com.spas.gcwl.controller.manager;

import com.spas.gcwl.entity.ProjectInfo;
import com.spas.gcwl.service.impl.ProjectInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ProjectInfoServiceImpl projectInfoService;

    @GetMapping("/list")
    public ModelAndView showList(){
        List<ProjectInfo> projectInfos=this.projectInfoService.findAllSubmittedProjectInfo();
        ModelAndView modelAndView=new ModelAndView("manager_list.html");
        modelAndView.addObject("projectlist",projectInfos);
        return modelAndView;
    }

}

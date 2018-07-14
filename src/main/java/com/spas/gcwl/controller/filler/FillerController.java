package com.spas.gcwl.controller.filler;

import com.spas.gcwl.entity.ProjectInfo;
import com.spas.gcwl.service.ProjectInfoService;
import com.spas.gcwl.service.impl.ProjectInfoServiceImpl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/filler")
public class FillerController {
    @Autowired
    ProjectInfoServiceImpl projectInfoService;

    @GetMapping("/list")
    public ModelAndView showList() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        List<ProjectInfo> projectInfos = this.projectInfoService.findAllSubmittedProjectInfoByUserme(username);

        ModelAndView modelAndView = new ModelAndView("filler_list.html");
        modelAndView.addObject("projectinfolist", projectInfos);
        return modelAndView;
    }

    //业务员提交项目（询价）页面
    @GetMapping("/add")
    public ModelAndView submitPage() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        ModelAndView modelAndView = new ModelAndView("filler_add");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView submit(ProjectInfo projectInfo) throws ParseException {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        ModelAndView modelAndView=new ModelAndView("filler_add");
        String s = "submitted";
        projectInfo.setState(s);
        projectInfo.setUserme(username);
        this.projectInfoService.submitProjectInfo(projectInfo);
        return  modelAndView;
}

    @GetMapping("/delete/{project_id}")
    public ModelAndView deleteProject(@PathVariable("project_id") Integer project_id){
        this.projectInfoService.deleteProjecctInfoById(project_id);
        ModelAndView mv=new ModelAndView("forward:/filler/add");
        return mv;
    }
}

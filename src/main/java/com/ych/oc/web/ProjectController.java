package com.ych.oc.web;

import com.ych.oc.Occupation;
import com.ych.oc.data.OccupationRepo;
import com.ych.oc.data.Project;
import com.ych.oc.data.ProjectRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;

/**
 * Created by ricyang on 16-7-27.
 */
@Controller
@RequestMapping("/ocs")
public class ProjectController {

    @Resource
    private OccupationRepo ocRepo;

    @Resource
    private ProjectRepo projectRepo;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody Collection<Project> get() {
        return projectRepo.getProjects();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public @ResponseBody int count(HttpServletRequest request) {
        String path = request.getPathInfo();
        System.out.println(path);
        return ocRepo.count();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody int newProject(@RequestBody Project project) {
        projectRepo.addProject(project);
        return 102;
    }
}

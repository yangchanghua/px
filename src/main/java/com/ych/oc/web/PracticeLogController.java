package com.ych.oc.web;

import com.ych.oc.data.PracticeLog;
import com.ych.oc.data.PracticeLogDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by ricyang on 16-8-18.
 */
@Controller
@RequestMapping("/practice")
public class PracticeLogController {

    @Resource
    private PracticeLogDAO theDAO;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public int newPracticeLog(@RequestBody
    PracticeLog practiceLog) {
        return theDAO.newPracticeLog(practiceLog);
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    @ResponseBody
    public Collection<PracticeLog> getPracticeLogs() {
        return theDAO.getAll();
    }
}

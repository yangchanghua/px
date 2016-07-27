package com.ych.oc.web;

import com.ych.oc.Occupation;
import com.ych.oc.data.OccupationRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created by ricyang on 16-7-27.
 */
@Controller
@RequestMapping("/ocs")
public class OccupationController {

    @Resource
    private OccupationRepo ocRepo;

    @RequestMapping("")
    public @ResponseBody Collection<Occupation> get() {
        return ocRepo.readAllOccupations();
    }
}

package com.ych.oc.data;

import com.ych.oc.EducationDegree;
import com.ych.oc.Occupation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ricyang on 16-7-27.
 */
@Component
public class OccupationRepo {

    public Collection<Occupation> readAllOccupations() {
        ArrayList<Occupation> res = new ArrayList<Occupation>();
        Occupation oc = new Occupation("programmer", "design and implement software system using programming languages and tools", 10000,
                EducationDegree.HIGH_SCHOOL);
        res.add(oc);
        return res;
    }
}

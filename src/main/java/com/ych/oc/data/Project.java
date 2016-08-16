package com.ych.oc.data;

import java.util.Date;

/**
 * Created by ricyang on 16-8-16.
 */
public class Project {
    private String domain;
    private String subDomain;
    private Date startDate;
    private int hours;

    public Project() {
    }

    public Project(String domain, String subDomain, Date startDate, int hours) {
        this.domain = domain;
        this.subDomain = subDomain;
        this.startDate = startDate;
        this.hours = hours;
    }

    public String getDomain() {

        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}

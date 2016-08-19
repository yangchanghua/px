package com.ych.oc.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created by ricyang on 16-8-18.
 */
public class PracticeLog {

    private int id;

    private Project project;

    private Date practiceDate;

    private int hours;

    private String note;

    @Override
    public String toString() {
        return "PracticeLog{" +
                "id=" + id +
                ", project=" + project +
                ", when=" + practiceDate +
                ", hours=" + hours +
                ", note='" + note + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(Date when) {
        this.practiceDate = when;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

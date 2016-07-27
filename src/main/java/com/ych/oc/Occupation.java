package com.ych.oc;

import java.io.Serializable;

/**
 * Created by ricyang on 16-7-27.
 */
public class Occupation implements Serializable {
    private String name;
    private String description;
    private int averageSalary;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAverageSalary() {
        return averageSalary;
    }

    public EducationDegree getMinimumDegree() {
        return minimumDegree;
    }

    private EducationDegree minimumDegree;

    @Override
    public String toString() {
        return "Occupation{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", averageSalary=" + averageSalary +
                ", minimumDegree=" + minimumDegree +
                '}';
    }

    public Occupation(String name, String description, int averageSalary, EducationDegree minimumDegree) {
        this.name = name;
        this.description = description;
        this.averageSalary = averageSalary;
        this.minimumDegree = minimumDegree;
    }
}

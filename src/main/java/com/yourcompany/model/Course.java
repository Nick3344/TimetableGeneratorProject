package main.java.com.yourcompany.model;

import java.util.*;
import java.lang.*;
public class Course {
    private String name;
    private int duration; // in hours
    private List<Course> prerequisites;

    public Course(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.prerequisites = new ArrayList<>();

    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void addPrerequisite(Course prerequisite) {
        this.prerequisites.add(prerequisite);
    }
}


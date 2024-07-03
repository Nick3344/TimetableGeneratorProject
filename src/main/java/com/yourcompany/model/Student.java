package main.java.com.yourcompany.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> preferredCourses;

    public Student(String name) {
        this.name = name;
        this.preferredCourses = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getPreferredCourses() {
        return preferredCourses;
    }

    public void setPreferredCourses(List<Course> preferredCourses) {
        this.preferredCourses = preferredCourses;
    }

    public void addPreferredCourse(Course course) {
        this.preferredCourses.add(course);
    }
}

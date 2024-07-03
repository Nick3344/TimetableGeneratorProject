package main.java.com.yourcompany;


import com.yourcompany.model.Course;
import com.yourcompany.model.Professor;
import com.yourcompany.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timetable {
    private List<Course> courses;
    private Map<Course, Professor> courseProfessorMap;
    private Map<Course, Room> courseRoomMap;

    public Timetable() {
        this.courses = new ArrayList<>();
        this.courseProfessorMap = new HashMap<>();
        this.courseRoomMap = new HashMap<>();
    }

    // Methods to manage courses, professors, and rooms
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void assignProfessor(Course course, Professor professor) {
        this.courseProfessorMap.put(course, professor);
    }

    public void assignRoom(Course course, Room room) {
        this.courseRoomMap.put(course, room);
    }

    public Professor getProfessorForCourse(Course course) {
        return this.courseProfessorMap.get(course);
    }

    public Room getRoomForCourse(Course course) {
        return this.courseRoomMap.get(course);
    }

}

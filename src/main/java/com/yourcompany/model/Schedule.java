package main.java.com.yourcompany.model;

import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private Map<String, Map<String, Course>> timetable; // Day -> TimeSlot -> Course

    public Schedule() {
        this.timetable = new HashMap<>();
    }

    public void addCourse(String day, String timeSlot, Course course) {
        this.timetable.computeIfAbsent(day, k -> new HashMap<>()).put(timeSlot, course);
    }

    public Course getCourse(String day, String timeSlot) {
        return this.timetable.getOrDefault(day, new HashMap<>()).get(timeSlot);
    }

}

package main.java.com.yourcompany.model;

import java.util.ArrayList;
import java.util.List;

public class TimetableGenerator {
    private List<Course> courses;
    private List<Professor> professors;
    private List<Room> rooms;
    private List<Student> students;
    private Schedule schedule;

    public TimetableGenerator(List<Course> courses, List<Professor> professors, List<Room> rooms, List<Student> students) {
        this.courses = courses;
        this.professors = professors;
        this.rooms = rooms;
        this.students = students;
        this.schedule = new Schedule();
    }

    public void generateTimetable() {
        // Assign professors and rooms to courses
        assignProfessors();
        assignRooms();

        // Generate schedule based on student preferences
        generateSchedule();
    }

    private void assignProfessors() {
        for (Course course : courses) {
            Professor professor = findAvailableProfessor(course);
            if (professor != null) {
                course.setProfessor(professor);
                professor.addCourse(course);
            } else {
                System.out.println("No available professor found for course: " + course.getName());
            }
        }
    }

    private Professor findAvailableProfessor(Course course) {
        for (Professor professor : professors) {
            if (professor.isAvailable()) {
                return professor;
            }
        }
        return null;
    }

    private void assignRooms() {
        for (Course course : courses) {
            Room room = findAvailableRoom(course);
            if (room != null) {
                course.setRoom(room);
                room.addCourse(course);
            } else {
                System.out.println("No available room found for course: " + course.getName());
            }
        }
    }

    private Room findAvailableRoom(Course course) {
        for (Room room : rooms) {
            if (room.isAvailable()) {
                return room;
            }
        }
        return null;
    }

    private void generateSchedule() {
        for (Student student : students) {
            List<Course> preferredCourses = student.getPreferredCourses();
            for (Course course : preferredCourses) {
                schedule.addCourse(student.getDayPreference(), student.getTimeSlotPreference(), course);
            }
        }
    }

    public Schedule getSchedule() {
        return schedule;
    }

    // Other methods for managing the timetable generation process
}


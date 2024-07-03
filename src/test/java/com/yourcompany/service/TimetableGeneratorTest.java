package test.java.com.yourcompany.service;

import com.yourcompany.TimetableGenerator;
import com.yourcompany.model.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TimetableGeneratorTest {

    private List<Course> courses;
    private List<Professor> professors;
    private List<Room> rooms;
    private List<Student> students;

    @Before
    public void setUp() {
        // Initialize sample data for testing
        courses = new ArrayList<>();
        professors = new ArrayList<>();
        rooms = new ArrayList<>();
        students = new ArrayList<>();

        // Populate courses
        Course course1 = new Course("Math", 3);
        Course course2 = new Course("Physics", 4);
        courses.add(course1);
        courses.add(course2);

        // Populate professors
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");
        professors.add(professor1);
        professors.add(professor2);

        // Populate rooms
        Room room1 = new Room("R101", 50);
        Room room2 = new Room("R102", 40);
        rooms.add(room1);
        rooms.add(room2);

        // Populate students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        List<Course> student1Preferences = new ArrayList<>();
        student1Preferences.add(course1);
        List<Course> student2Preferences = new ArrayList<>();
        student2Preferences.add(course2);
        student2Preferences.add(course1);
        student1.setPreferredCourses(student1Preferences);
        student2.setPreferredCourses(student2Preferences);
        students.add(student1);
        students.add(student2);
    }

    @Test
    public void testGenerateTimetable() {
        TimetableGenerator generator = new TimetableGenerator(courses, professors, rooms, students);
        generator.generateTimetable();

        Schedule schedule = generator.getSchedule();

        // Assert that schedule is not null
        assertNotNull(schedule);

        // Assert that courses are assigned to professors and rooms
        for (Course course : courses) {
            assertNotNull(course.getProfessor());
            assertNotNull(course.getRoom());
        }

        // Assert that student preferences are considered in the schedule
        for (Student student : students) {
            List<Course> preferredCourses = student.getPreferredCourses();
            for (Course course : preferredCourses) {
                assertNotNull(schedule.getCourse(student.getDayPreference(), student.getTimeSlotPreference()));
                assertEquals(course, schedule.getCourse(student.getDayPreference(), student.getTimeSlotPreference()));
            }
        }
    }
}


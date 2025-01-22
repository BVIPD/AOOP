package task5;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String studentId;
    private List<String> enrolledCourses;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void addCourse(String courseId) {
        this.enrolledCourses.add(courseId);
    }

    public void removeCourse(String courseId) {
        this.enrolledCourses.remove(courseId);
    }
}

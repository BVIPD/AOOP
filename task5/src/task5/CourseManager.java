package task5;

import java.util.HashMap;
import java.util.Map;

public class CourseManager implements CourseManagement {
    private Map<String, Course> courses;

    public CourseManager() {
        courses = new HashMap<>();
    }

    @Override
    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    @Override
    public void removeCourse(String courseId) {
        courses.remove(courseId);
    }

    @Override
    public Course getCourse(String courseId) {
        return courses.get(courseId);
    }
}


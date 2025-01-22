package task5;

public interface CourseManagement {
    void addCourse(Course course);
    void removeCourse(String courseId);
    Course getCourse(String courseId);
}

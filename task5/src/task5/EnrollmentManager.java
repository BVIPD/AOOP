package task5;

public class EnrollmentManager implements EnrollmentManagement {
    private StudentManagement studentManagement;
    private CourseManagement courseManagement;

    public EnrollmentManager(StudentManagement studentManagement, CourseManagement courseManagement) {
        this.studentManagement = studentManagement;
        this.courseManagement = courseManagement;
    }

    @Override
    public void enrollStudent(String studentId, String courseId) {
        Student student = studentManagement.getStudent(studentId);
        Course course = courseManagement.getCourse(courseId);
        if (student != null && course != null) {
            student.addCourse(courseId);
            course.addStudent(student);
        }
    }

    @Override
    public void unenrollStudent(String studentId, String courseId) {
        Student student = studentManagement.getStudent(studentId);
        Course course = courseManagement.getCourse(courseId);
        if (student != null && course != null) {
            student.removeCourse(courseId);
            course.removeStudent(student);
        }
    }
}

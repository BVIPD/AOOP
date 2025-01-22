package task5;

public class SISApplication {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManager();
        CourseManagement courseManagement = new CourseManager();

        Student student1 = new Student("John Doe", "S001");
        Student student2 = new Student("Jane Smith", "S002");

        Course course1 = new Course("C001", "Math 101");
        Course course2 = new Course("C002", "Science 101");

        studentManagement.addStudent(student1);
        studentManagement.addStudent(student2);
        courseManagement.addCourse(course1);
        courseManagement.addCourse(course2);

        EnrollmentManager enrollmentManager = new EnrollmentManager(studentManagement, courseManagement);
        enrollmentManager.enrollStudent("S001", "C001");
        enrollmentManager.enrollStudent("S002", "C002");

        System.out.println(student1.getName() + " enrolled in " + student1.getEnrolledCourses());
        System.out.println(student2.getName() + " enrolled in " + student2.getEnrolledCourses());
    }
}

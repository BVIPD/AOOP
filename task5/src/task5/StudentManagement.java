package task5;

public interface StudentManagement {
    void addStudent(Student student);
    void removeStudent(String studentId);
    Student getStudent(String studentId);
}

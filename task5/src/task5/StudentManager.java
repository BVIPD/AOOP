package task5;

import java.util.HashMap;
import java.util.Map;

public class StudentManager implements StudentManagement {
    private Map<String, Student> students;

    public StudentManager() {
        students = new HashMap<>();
    }

    @Override
    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    @Override
    public void removeStudent(String studentId) {
        students.remove(studentId);
    }

    @Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }
}

package task8_2;
import java.util.*;
public class StudentGrades {
    private Map<Integer, Set<Integer>> studentGrades;
    public StudentGrades() {
        studentGrades = new HashMap<>();
    }
    public void addGrade(int studentID, int grade) {
        studentGrades.putIfAbsent(studentID, new HashSet<>());
        studentGrades.get(studentID).add(grade);
        System.out.println("Grade added for Student ID: " + studentID);
    }
    public void displayAllGrades() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student grades available.");
            return;
        }
        System.out.println("Student Grades:");
        for (Map.Entry<Integer, Set<Integer>> entry : studentGrades.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + " -> Grades: " + entry.getValue());
        }
    }
    public void getGrades(int studentID) {
        if (studentGrades.containsKey(studentID)) {
            System.out.println("Student ID: " + studentID + " -> Grades: " + studentGrades.get(studentID));
        } else {
            System.out.println("No grades found for Student ID: " + studentID);
        }
    }
}

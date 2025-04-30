package task8_2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentGrades sg = new StudentGrades();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Student Grade Menu -----");
            System.out.println("1. Add Grade");
            System.out.println("2. Display All Grades");
            System.out.println("3. Retrieve Grades by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    int grade = sc.nextInt();
                    sg.addGrade(studentID, grade);
                    break;

                case 2:
                    sg.displayAllGrades();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sg.getGrades(id);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

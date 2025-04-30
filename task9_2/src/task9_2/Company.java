package task9_2;
import java.util.*;

public class Company {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30, "HR", 50000),
                new Employee("Alice", 28, "IT", 70000),
                new Employee("Bob", 35, "Finance", 60000),
                new Employee("Charlie", 26, "IT", 80000),
                new Employee("David", 40, "HR", 55000)
        );
        System.out.println("Employees in IT Department:");
        employees.stream()
                .filter(e -> e.department.equals("IT"))
                .forEach(System.out::println);


        System.out.println("\nEmployees Sorted by Name:");
        employees.stream()
                .sorted(Comparator.comparing(e -> e.name))
                .forEach(System.out::println);

        Optional<Employee> highestSalary = employees.stream()
                .max(Comparator.comparingDouble(e -> e.salary));

        highestSalary.ifPresent(e -> System.out.println("\nEmployee with Highest Salary: " + e));
        double averageSalary = employees.stream()
                .mapToDouble(e -> e.salary)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Salary: " + averageSalary);
    }
}

package task9_1;
import java.util.*;
import java.util.function.Predicate;
public class CoffeeShop {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Employee1", 30, 5));
        employees.add(new Employee("Employee2", 28, 4));
        employees.add(new Employee("Employee3", 25, 3));
        employees.add(new Employee("Employee4", 23, 1));
        employees.add(new Employee("Employee5", 22, 0));
        PriorityQueue<Employee> queue = new PriorityQueue<>((e1, e2) -> e2.experience - e1.experience);
        queue.addAll(employees);
        Predicate<Employee> bonusEligibility = e -> e.experience > 2;
        System.out.println("\nDistributing Salaries:");
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            System.out.println(e);

            if (bonusEligibility.test(e)) {
                System.out.println("Bonus Eligible ✅");
            } else {
                System.out.println("No Bonus ❌");
            }
        }
    }
}

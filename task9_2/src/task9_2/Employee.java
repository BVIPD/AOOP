package task9_2;
public class Employee {
    String name;
    int age;
    String department;
    double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Department: " + department + ", Salary: " + salary;
    }
}

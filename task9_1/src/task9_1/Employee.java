package task9_1;

public class Employee {
    String name;
    int age;
    int experience;

    public Employee(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Experience: " + experience + " years";
    }
}

package task7_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSorter {
	 public static void main(String[] args) { 
		 
	        List<Employee> employees = new ArrayList<>(); 
	        employees.add(new Employee(1, "John Doe", "Engineering", 75000)); 
	        employees.add(new Employee(2, "Jane Smith", "HR", 60000)); 
	        employees.add(new Employee(3, "Mary Johnson", "Engineering", 82000)); 
	        employees.add(new Employee(4, "James Brown", "Finance", 90000)); 
	        employees.add(new Employee(5, "Emily Davis", "HR", 70000)); 
	 
	        System.out.println("Employees sorted by Salary (Ascending):"); 
	        Collections.sort(employees, new SortBySalaryAscending()); 
	        employees.forEach(System.out::println); 
	 
	        System.out.println("\nEmployees sorted by Salary (Descending):"); 
	        Collections.sort(employees, new SortBySalaryDescending()); 
	        employees.forEach(System.out::println); 
	 
	        System.out.println("\nEmployees sorted by Name (Alphabetical):"); 
	        Collections.sort(employees, new SortByName()); 
	        employees.forEach(System.out::println); 
	 
	        System.out.println("\nEmployees sorted by Department (Alphabetical):"); 
	        Collections.sort(employees, new SortByDepartment()); 
	        employees.forEach(System.out::println);
	 }
}

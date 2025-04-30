package task7_2;

import java.util.Comparator;

public class SortBySalaryAscending implements Comparator<Employee> { 
    public int compare(Employee e1, Employee e2) { 
        return Double.compare(e1.getSalary(), e2.getSalary()); 
    } 
} 
package task7_2;

import java.util.Comparator;

public class SortBySalaryDescending implements Comparator<Employee> { 
   public int compare(Employee e1, Employee e2) { 
       return Double.compare(e2.getSalary(), e1.getSalary()); 
   } 
}
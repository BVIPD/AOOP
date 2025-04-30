package task7_2;

import java.util.Comparator;

class SortByDepartment implements Comparator<Employee> { 
    @Override 
    public int compare(Employee e1, Employee e2) { 
        return e1.getDepartment().compareTo(e2.getDepartment()); 
    } 
}
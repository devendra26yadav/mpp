package Labs_solutions.lab10.prob2.partA;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2){
        int nameCmp = e1.name.compareTo(e2.name);
        if(nameCmp!=0) return nameCmp;
        return Integer.compare(e1.salary,e2.salary);
    }
}

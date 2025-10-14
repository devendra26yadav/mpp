package Labs_solutions.lab10.prob2.partB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	
	public void sort(List<Employee> emps, final SortMethod method) {

		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				if(method == SortMethod.BYNAME) {
					int nameCmp =e1.name.compareTo(e2.name);
					if(nameCmp!=0) return nameCmp;
					return Integer.compare(e1.salary, e2.salary);
				} else {
					int salaryCmp = Integer.compare(e1.salary,e2.salary);
					if(salaryCmp!=0) return salaryCmp;
					return e1.name.compareTo(e2.name);
				}
			}
		}
		Collections.sort(emps, new EmployeeComparator());
	}
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 60000));
		EmployeeInfo ei = new EmployeeInfo();
		ei.sort(emps, SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, SortMethod.BYSALARY);
		System.out.println(emps);
	}
}

/*
[<name: Andy salary: 60000>, <name: Joe salary: 100000>, <name: Tim salary: 50000>]
[<name: Tim salary: 50000>, <name: Andy salary: 60000>, <name: Joe salary: 100000>]
 */
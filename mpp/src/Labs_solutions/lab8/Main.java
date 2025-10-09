
import Model.Employee;
import Repository.EmployeeRepository;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository er = new EmployeeRepository();
        System.out.println("Creating Employee");
        Employee emp = new Employee(117,"John",145000,2,4);
        System.out.println(emp);
        er.create(emp);
        System.out.println("\nAll Employees");
        for(Employee e:er.findAll()){
            System.out.println(e);
        }
        System.out.println("\nGet Employee Details for Id = 115");
        System.out.println(er.findById(115));
        emp.setSalary(245000);
        er.update(emp);
        System.out.println("\nDeleting Employee with id 117");
        er.delete(117);

        System.out.println("\nAll Employees");
        for(Employee e:er.findAll()){
            System.out.println(e);
        }


    }
}
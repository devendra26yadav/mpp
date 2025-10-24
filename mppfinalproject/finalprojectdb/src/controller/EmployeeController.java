package controller;

import model.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

import java.util.List;
import java.util.Objects;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController() {
       try {
           EmployeeRepository employeeRepository = new EmployeeRepository();
           this.employeeService = new EmployeeService(employeeRepository);
       }catch (Exception e) {
           throw new RuntimeException(e);
       }
    }


    public void createEmployee(Employee e) {
        try {
            employeeService.createEmployee(e);
            System.out.println("Employee created successfully: " + e.getFullName());
        } catch (Exception ex) {
            System.out.println("Error creating employee: " + ex.getMessage());
        }
    }

    public Employee getEmployeeById(int id) {
        try {
            Employee e = employeeService.getEmployeeById(id);
            System.out.println("Employee: " + e.getFullName() + ", Title: " + e.getTitle());
            return e;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return new Employee();
        }
    }

    public void getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            System.out.println("Using StreamAPI");
            employees.stream()
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void updateEmployee(Employee e) {
        try {
            employeeService.updateEmployee(e);
            System.out.println("Employee updated successfully: " + e.getFullName());
        } catch (Exception ex) {
            System.out.println("Error updating employee: " + ex.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        try {
            employeeService.deleteEmployee(id);
            System.out.println("Employee deleted successfully, ID: " + id);
        } catch (Exception ex) {
            System.out.println("Error deleting employee: " + ex.getMessage());
        }
    }


    public void transferEmployeeToDepartment(int employeeId, int newDepartmentId) {
        try {
            employeeService.transferEmployeeToDepartment(employeeId, newDepartmentId);
        } catch (Exception e) {
            System.out.println("Error transferring employee: " + e.getMessage());
        }
    }
}

package controller;

import model.Employee;
import service.EmployeeService;

import java.time.LocalDate;

public class EmployeeController {
    private final EmployeeService service = new EmployeeService();

    public void createSampleEmployee() {
        Employee employee = new Employee(1, "Alice Johnson", "Developer", LocalDate.of(2023, 1, 10), 70000, 1);
        service.createEmployee(employee);
        System.out.println("Employee created.");
    }

    public void listAllEmployees() {
        service.getAllEmployees().forEach(System.out::println);
    }
    public void transferEmployee(int employeeId, int newDepartmentId) {
        System.out.println("Transferring employee #" + employeeId + " to department #" + newDepartmentId);
        service.transferEmployeeToDepartment(employeeId, newDepartmentId);
    }
}

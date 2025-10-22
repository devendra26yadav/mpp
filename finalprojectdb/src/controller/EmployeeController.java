package controller;

import model.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

import java.util.List;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController() throws Exception {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        this.employeeService = new EmployeeService(employeeRepository);
    }


    // ----------------- CREATE -----------------
    public void createEmployee(Employee e) {
        try {
            employeeService.createEmployee(e);
            System.out.println("Employee created successfully: " + e.getFullName());
        } catch (Exception ex) {
            System.out.println("Error creating employee: " + ex.getMessage());
        }
    }

    // ----------------- READ SINGLE -----------------
    public void getEmployeeById(int id) {
        try {
            Employee e = employeeService.getEmployeeById(id);
            System.out.println("Employee: " + e.getFullName() + ", Title: " + e.getTitle());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // ----------------- READ ALL -----------------
    public void getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            for (Employee e : employees) {
                System.out.println("ID: " + e.getId() + ", Name: " + e.getFullName() +
                        ", DeptID: " + e.getDepartmentId());
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // ----------------- UPDATE -----------------
    public void updateEmployee(Employee e) {
        try {
            employeeService.updateEmployee(e);
            System.out.println("Employee updated successfully: " + e.getFullName());
        } catch (Exception ex) {
            System.out.println("Error updating employee: " + ex.getMessage());
        }
    }

    // ----------------- DELETE -----------------
    public void deleteEmployee(int id) {
        try {
            employeeService.deleteEmployee(id);
            System.out.println("Employee deleted successfully, ID: " + id);
        } catch (Exception ex) {
            System.out.println("Error deleting employee: " + ex.getMessage());
        }
    }

    /**
     * Controller method to transfer employee to a new department
     */
    public void transferEmployeeToDepartment(int employeeId, int newDepartmentId) {
        try {
            employeeService.transferEmployeeToDepartment(employeeId, newDepartmentId);
        } catch (Exception e) {
            System.out.println("Error transferring employee: " + e.getMessage());
        }
    }
}

package service;

import model.Department;
import model.Employee;
import repository.EmployeeRepository;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Connection connection;

    public EmployeeService(EmployeeRepository employeeRepository) throws SQLException {
        this.employeeRepository = employeeRepository;
        this.connection = DBConnection.getConnection();
    }

    // ----------------- CREATE -----------------
    public void createEmployee(Employee employee) throws Exception {
        if (employee.getSalary() < 0) throw new Exception("Salary cannot be negative");
        employeeRepository.createEmployee(employee);
    }

    // ----------------- READ SINGLE -----------------
    public Employee getEmployeeById(int id) throws Exception {
        Employee e = employeeRepository.getEmployeeById(id);
        if (e == null) throw new Exception("Employee not found");
        return e;
    }

    // ----------------- READ ALL -----------------
    public List<Employee> getAllEmployees() throws Exception {
        return employeeRepository.getAllEmployees();
    }

    // ----------------- UPDATE -----------------
    public void updateEmployee(Employee employee) throws Exception {
        Employee existing = employeeRepository.getEmployeeById(employee.getId());
        if (existing == null) throw new Exception("Employee not found");
        employeeRepository.updateEmployee(employee);
    }

    // ----------------- DELETE -----------------
    public void deleteEmployee(int id) throws Exception {
        Employee existing = employeeRepository.getEmployeeById(id);
        if (existing == null) throw new Exception("Employee not found");
        employeeRepository.deleteEmployee(id);
    }

    /**
     * Transfer employee to a new department (transactional)
     */
    public void transferEmployeeToDepartment(int employeeId, int newDepartmentId) throws Exception {
        try {
            connection.setAutoCommit(false); // start transaction

            // Validate Employee
            Employee employee = employeeRepository.getEmployeeById(employeeId);
            if (employee == null) {
                throw new Exception("Employee not found with ID: " + employeeId);
            }

            // Validate Department
            Department newDept = employeeRepository.getDepartmentById(newDepartmentId);
            if (newDept == null) {
                throw new Exception("Department not found with ID: " + newDepartmentId);
            }

            // Perform transfer
            employeeRepository.updateEmployeeDepartment(employeeId, newDepartmentId);

            connection.commit(); // commit transaction
            System.out.println("Employee ID " + employeeId + " successfully transferred to Department ID " + newDepartmentId);

        } catch (Exception e) {
            connection.rollback(); // rollback on error
            throw new Exception("Transfer failed: " + e.getMessage());
        } finally {
            connection.setAutoCommit(true); // restore default
        }
    }
}

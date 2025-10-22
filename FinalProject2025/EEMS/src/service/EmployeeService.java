package service;

import model.Employee;
import repository.EmployeeRepository;
import util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepository repository = new EmployeeRepository();

    public void createEmployee(Employee employee) {
        if (employee.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }

        try {
            repository.save(employee);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not create employee.");
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            return repository.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            repository.update(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try {
            repository.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void transferEmployeeToDepartment(int employeeId, int newDepartmentId) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // Start transaction

            if (!repository.employeeExists(employeeId, conn)) {
                throw new IllegalArgumentException("No Employee with ID " + employeeId + " does not exist.");
            }

            if (!repository.departmentExists(newDepartmentId, conn)) {
                throw new IllegalArgumentException("No Department with ID " + newDepartmentId + " does not exist.");
            }

            repository.updateEmployeeDepartment(employeeId, newDepartmentId, conn);

            conn.commit();
            System.out.println("Employee transferred successfully.");

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            try {
                System.out.println("Rolling back due to error...");
                DBConnection.getConnection().rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    }
}


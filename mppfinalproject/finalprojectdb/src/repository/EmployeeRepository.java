package repository;


import model.Department;
import model.Employee;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private final Connection connection;

    public EmployeeRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    public void createEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employee (id, fullName, title, hireDate, salary, departmentId) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFullName());
            ps.setString(3, employee.getTitle());
            ps.setDate(4, employee.getHireDate());
            ps.setDouble(5, employee.getSalary());
            ps.setInt(6, employee.getDepartmentId());
            ps.executeUpdate();
        }
    }


    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setFullName(rs.getString("fullName"));
                e.setTitle(rs.getString("title"));
                e.setHireDate(rs.getDate("hireDate"));
                e.setSalary(rs.getDouble("salary"));
                e.setDepartmentId(rs.getInt("departmentId"));
                employees.add(e);
            }
        }
        return employees;
    }


    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE Employee SET fullName = ?, title = ?, hireDate = ?, salary = ?, departmentId = ? " +
                "WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, employee.getFullName());
            ps.setString(2, employee.getTitle());
            ps.setDate(3, new Date(employee.getHireDate().getTime()));
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getDepartmentId());
            ps.setInt(6, employee.getId());
            ps.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM Employee WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No employee found with ID: " + id);
            }
        }
    }


    public Employee getEmployeeById(int employeeId) throws SQLException {
        String sql = "SELECT id, fullName, title, hireDate, salary, departmentId FROM Employee WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setFullName(rs.getString("fullName"));
                e.setTitle(rs.getString("title"));
                e.setHireDate(rs.getDate("hireDate"));
                e.setSalary(rs.getDouble("salary"));
                e.setDepartmentId(rs.getInt("departmentId"));
                return e;
            }
        }
        return null;
    }


    public Department getDepartmentById(int departmentId) throws SQLException {
        String sql = "SELECT id, name, location, annualBudget FROM Department WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Department d = new Department();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setLocation(rs.getString("location"));
                d.setAnnualBudget(rs.getDouble("annualBudget"));
                return d;
            }
        }
        return null;
    }


    public void updateEmployeeDepartment(int employeeId, int newDepartmentId) throws SQLException {
        String sql = "UPDATE Employee SET departmentId = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, newDepartmentId);
            ps.setInt(2, employeeId);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("Employee update failed, no rows affected.");
            }
        }
    }
}

package repository;

import model.Department;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private final Connection connection;

    public DepartmentRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    // ----------------- CREATE -----------------
    public void createDepartment(Department dept) throws SQLException {
        String sql = "INSERT INTO Department (id, name, location, annualBudget) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, dept.getId());
            ps.setString(2, dept.getName());
            ps.setString(3, dept.getLocation());
            ps.setDouble(4, dept.getAnnualBudget());
            ps.executeUpdate();
        }
    }

    // ----------------- READ SINGLE -----------------
    public Department getDepartmentById(int id) throws SQLException {
        String sql = "SELECT * FROM Department WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
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

    // ----------------- READ ALL -----------------
    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Department";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department d = new Department();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setLocation(rs.getString("location"));
                d.setAnnualBudget(rs.getDouble("annualBudget"));
                departments.add(d);
            }
        }
        return departments;
    }

    // ----------------- UPDATE -----------------
    public void updateDepartment(Department dept) throws SQLException {
        String sql = "UPDATE Department SET name = ?, location = ?, annualBudget = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dept.getName());
            ps.setString(2, dept.getLocation());
            ps.setDouble(3, dept.getAnnualBudget());
            ps.setInt(4, dept.getId());
            ps.executeUpdate();
        }
    }

    // ----------------- DELETE -----------------
    public void deleteDepartment(int id) throws SQLException {
        String sql = "DELETE FROM Department WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No department found with ID: " + id);
            }
        }
    }
}

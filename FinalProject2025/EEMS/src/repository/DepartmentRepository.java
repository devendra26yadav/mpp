package repository;

import model.Department;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    public void create(Department department) throws SQLException {
        String sql = "INSERT INTO Department (id, name, location, annualBudget) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, department.getId());
            stmt.setString(2, department.getName());
            stmt.setString(3, department.getLocation());
            stmt.setDouble(4, department.getAnnualBudget());
            stmt.executeUpdate();
        }
    }

    public Department read(int id) throws SQLException {
        String sql = "SELECT * FROM Department WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Department(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("annualBudget")
                );
            }
            return null;
        }
    }

    public List<Department> readAll() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Department";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                departments.add(new Department(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getDouble("annualBudget")
                ));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return departments;
    }

    public void update(Department department) throws SQLException {
        String sql = "UPDATE Department SET name = ?, location = ?, annualBudget = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, department.getName());
            stmt.setString(2, department.getLocation());
            stmt.setDouble(3, department.getAnnualBudget());
            stmt.setInt(4, department.getId());

            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        // Check referential integrity (e.g., employees assigned to this department)
        String checkSql = "SELECT COUNT(*) FROM Employee WHERE departmentId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                throw new SQLException("Cannot delete department with assigned employees.");
            }
        }

        String sql = "DELETE FROM Department WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Department with ID " + id + " does not exist.");
            }
        }
    }
}

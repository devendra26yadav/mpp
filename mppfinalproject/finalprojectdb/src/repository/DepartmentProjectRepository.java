package repository;

import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentProjectRepository {

    public boolean addAssignment(int departmentId, int projectId) {
        String sql = "INSERT INTO DepartmentProject (departmentId, projectId) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, departmentId);
            stmt.setInt(2, projectId);
            int rows = stmt.executeUpdate();
            System.out.println("Assignment added: Department " + departmentId + " -> Project " + projectId);
            return rows > 0;

        } catch (Exception e) {
            System.out.println("Error adding assignment: " + e.getMessage());
            return false;
        }
    }

    public List<String> getAllAssignments() {
        String sql = """
                SELECT d.name AS departmentName, p.name AS projectName
                FROM DepartmentProject dp
                JOIN Department d ON dp.departmentId = d.id
                JOIN Project p ON dp.projectId = p.id
                ORDER BY d.name
                """;
        List<String> results = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                results.add(rs.getString("departmentName") + " -> " + rs.getString("projectName"));
            }

        } catch (Exception e) {
            System.out.println("Error fetching all assignments: " + e.getMessage());
        }
        return results;
    }

    public List<String> getAssignmentsByDepartment(int departmentId) {
        String sql = """
                SELECT p.name AS projectName
                FROM DepartmentProject dp
                JOIN Project p ON dp.projectId = p.id
                WHERE dp.departmentId = ?
                """;
        List<String> projects = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, departmentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projects.add(rs.getString("projectName"));
            }

        } catch (Exception e) {
            System.out.println("Error fetching projects for department " + departmentId + ": " + e.getMessage());
        }
        return projects;
    }

    public List<String> getAssignmentsByProject(int projectId) {
        String sql = """
                SELECT d.name AS departmentName
                FROM DepartmentProject dp
                JOIN Department d ON dp.departmentId = d.id
                WHERE dp.projectId = ?
                """;
        List<String> departments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                departments.add(rs.getString("departmentName"));
            }

        } catch (Exception e) {
            System.out.println("Error fetching departments for project " + projectId + ": " + e.getMessage());
        }
        return departments;
    }

    public boolean removeAssignment(int departmentId, int projectId) {
        String sql = "DELETE FROM DepartmentProject WHERE departmentId = ? AND projectId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, departmentId);
            stmt.setInt(2, projectId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Assignment removed: Department " + departmentId + " -> Project " + projectId);
                return true;
            } else {
                System.out.println("No assignment found to remove.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error removing assignment: " + e.getMessage());
            return false;
        }
    }
}

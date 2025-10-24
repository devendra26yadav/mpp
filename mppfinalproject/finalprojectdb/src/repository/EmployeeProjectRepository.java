package repository;

import model.EmployeeProject;
import utils.DBConnection;
import java.sql.*;
import java.util.*;

public class EmployeeProjectRepository {
    private final Map<String, EmployeeProject> employeeProjects = new HashMap<>();
    // Key = "employeeId:projectId"

    private String makeKey(int employeeId, int projectId) {
        return employeeId + ":" + projectId;
    }
    public boolean add(EmployeeProject ep) {
        String sql = "INSERT INTO EmployeeProject (employeeId, projectId, allocationPercentage, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ep.getEmployeeId());
            ps.setInt(2, ep.getProjectId());
            ps.setDouble(3, ep.getAllocationPercentage());
            ps.setString(4, ep.getProject() != null ? ep.getProject().getName() : "Unknown");
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<EmployeeProject> getAll() {
        List<EmployeeProject> list = new ArrayList<>();
        String sql = "SELECT * FROM EmployeeProject";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                EmployeeProject ep = new EmployeeProject();
                ep.setEmployeeId(rs.getInt("employeeId"));
                ep.setProjectId(rs.getInt("projectId"));
                ep.setAllocationPercentage(rs.getDouble("allocationPercentage"));
                list.add(ep);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching EmployeeProjects: " + e.getMessage());
        }
        return list;
    }

    public List<EmployeeProject> getByEmployeeId(int employeeId) {
        List<EmployeeProject> list = new ArrayList<>();
        String sql = "SELECT * FROM EmployeeProject WHERE employeeId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EmployeeProject ep = new EmployeeProject();
                    ep.setEmployeeId(rs.getInt("employeeId"));
                    ep.setProjectId(rs.getInt("projectId"));
                    ep.setAllocationPercentage(rs.getDouble("allocationPercentage"));
                    list.add(ep);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching EmployeeProjects by Employee: " + e.getMessage());
        }
        return list;
    }

    public boolean delete(int employeeId, int projectId) {
        String sql = "DELETE FROM EmployeeProject WHERE employeeId = ? AND projectId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            ps.setInt(2, projectId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting EmployeeProject: " + e.getMessage());
            return false;
        }
    }
    public void update(EmployeeProject ep) {
        String sql = "UPDATE EmployeeProject SET allocationPercentage = ? WHERE employeeId = ? AND projectId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, ep.getAllocationPercentage());
            pstmt.setInt(2, ep.getEmployeeId());
            pstmt.setInt(3, ep.getProjectId());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("EmployeeProject updated successfully in DB");
            } else {
                System.out.println("No EmployeeProject found with given IDs.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

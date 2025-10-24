package repository;

import model.ProjectClient;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectClientRepository {

    public void create(ProjectClient pc) {
        String sql = "INSERT INTO ProjectClient (projectId, clientId) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, pc.getProjectId());
            pstmt.setInt(2, pc.getClientId());

            pstmt.executeUpdate();
            System.out.println("ProjectClient added successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<ProjectClient> getAll() {
        List<ProjectClient> list = new ArrayList<>();
        String sql = "SELECT * FROM ProjectClient";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ProjectClient pc = new ProjectClient(rs.getInt("projectId"), rs.getInt("clientId"));
                list.add(pc);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ProjectClient getById(int projectId, int clientId) {
        String sql = "SELECT * FROM ProjectClient WHERE projectId = ? AND clientId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, projectId);
            pstmt.setInt(2, clientId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new ProjectClient(rs.getInt("projectId"), rs.getInt("clientId"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delete(int projectId, int clientId) {
        String sql = "DELETE FROM ProjectClient WHERE projectId = ? AND clientId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, projectId);
            pstmt.setInt(2, clientId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("ProjectClient deleted successfully!");
            } else {
                System.out.println("No ProjectClient found with given IDs.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

package repository;

import model.Client;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private final Connection connection;

    public ClientRepository() throws SQLException {
        this.connection = DBConnection.getConnection();
    }

    public void createClient(Client client) throws SQLException {
        String sql = "INSERT INTO Client (id, name, industry, contactPersonName, contactPhone, contactEmail) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, client.getId());
            ps.setString(2, client.getName());
            ps.setString(3, client.getIndustry());
            ps.setString(4, client.getContactPersonName());
            ps.setString(5, client.getContactPhone());
            ps.setString(6, client.getContactEmail());
            ps.executeUpdate();
        }
    }


    public Client getClientById(int id) throws SQLException {
        String sql = "SELECT * FROM Client WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setIndustry(rs.getString("industry"));
                c.setContactPersonName(rs.getString("contactPersonName"));
                c.setContactPhone(rs.getString("contactPhone"));
                c.setContactEmail(rs.getString("contactEmail"));
                return c;
            }
        }
        return null;
    }


    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setIndustry(rs.getString("industry"));
                c.setContactPersonName(rs.getString("contactPersonName"));
                c.setContactPhone(rs.getString("contactPhone"));
                c.setContactEmail(rs.getString("contactEmail"));
                clients.add(c);
            }
        }
        return clients;
    }


    public void updateClient(Client client) throws SQLException {
        String sql = "UPDATE Client SET name = ?, industry = ?, contactPersonName = ?, contactPhone = ?, contactEmail = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getIndustry());
            ps.setString(3, client.getContactPersonName());
            ps.setString(4, client.getContactPhone());
            ps.setString(5, client.getContactEmail());
            ps.setInt(6, client.getId());
            ps.executeUpdate();
        }
    }


    public void deleteClient(int id) throws SQLException {
        // Delete from ProjectClient junction table first
        String sqlJunction = "DELETE FROM ProjectClient WHERE clientId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlJunction)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

        // Delete the client
        String sql = "DELETE FROM Client WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No client found with ID: " + id);
            }
        }
    }


    public List<Client> getClientsByProjectDeadline(int daysUntilDeadline) throws SQLException {
        List<Client> clients = new ArrayList<>();

        String sql = "SELECT DISTINCT c.id, c.name, c.industry, c.contactPersonName, c.contactPhone, c.contactEmail " +
                "FROM Client c " +
                "JOIN ProjectClient pc ON c.id = pc.clientId " +
                "JOIN Project p ON pc.projectId = p.id " +
                "WHERE p.endDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL ? DAY)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, daysUntilDeadline);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setIndustry(rs.getString("industry"));
                client.setContactPersonName(rs.getString("contactPersonName"));
                client.setContactPhone(rs.getString("contactPhone"));
                client.setContactEmail(rs.getString("contactEmail"));
                clients.add(client);
            }
        }

        return clients;
    }
}

package repository;

import model.Client;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public List<Client> findClientsByUpcomingProjectDeadline(int daysUntilDeadline) throws SQLException {
        List<Client> clients = new ArrayList<>();

        String sql = "SELECT DISTINCT c.id, c.name, c.industry, c.contactPersonName, c.contactPhone, c.contactEmail "
           + " FROM Client c JOIN ProjectClient pc ON c.id = pc.clientId "+
            " JOIN Project p ON pc.projectId = p.id WHERE p.endDate <= ? ";

        LocalDate deadline = LocalDate.now().plusDays(daysUntilDeadline);

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(deadline));
            ResultSet rs = stmt.executeQuery();

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clients;
    }
}

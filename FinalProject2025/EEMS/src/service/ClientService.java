package service;

import model.Client;
import repository.ClientRepository;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository = new ClientRepository();

    public List<Client> findClientsByUpcomingProjectDeadline(int daysUntilDeadline) {
        try {
            return clientRepository.findClientsByUpcomingProjectDeadline(daysUntilDeadline);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding clients by project deadline.");
        }
    }
}

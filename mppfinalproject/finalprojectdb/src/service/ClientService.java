package service;


import model.Client;
import repository.ClientRepository;

import java.util.List;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void createClient(Client client) throws Exception {
        if (client.getName() == null || client.getName().isEmpty()) {
            throw new Exception("Client name cannot be empty");
        }
        clientRepository.createClient(client);
    }


    public Client getClientById(int id) throws Exception {
        Client c = clientRepository.getClientById(id);
        if (c == null) throw new Exception("Client not found");
        return c;
    }


    public List<Client> getAllClients() throws Exception {
        return clientRepository.getAllClients();
    }


    public void updateClient(Client client) throws Exception {
        Client existing = clientRepository.getClientById(client.getId());
        if (existing == null) throw new Exception("Client not found");
        clientRepository.updateClient(client);
    }


    public void deleteClient(int id) throws Exception {
        Client existing = clientRepository.getClientById(id);
        if (existing == null) throw new Exception("Client not found");
        clientRepository.deleteClient(id);
    }


    public List<Client> findClientsByUpcomingProjectDeadline(int daysUntilDeadline) throws Exception {
        if (daysUntilDeadline <= 0) {
            throw new IllegalArgumentException("daysUntilDeadline must be positive");
        }
        return clientRepository.getClientsByProjectDeadline(daysUntilDeadline);
    }
}

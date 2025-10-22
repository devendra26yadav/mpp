package controller;

import model.Client;
import repository.ClientRepository;
import service.ClientService;

import java.util.List;

public class ClientController {

    private final ClientService clientService;

    public ClientController() throws Exception {
        ClientRepository clientRepository = new ClientRepository();
        this.clientService = new ClientService(clientRepository);
    }


    // ----------------- CREATE -----------------
    public void createClient(Client c) {
        try {
            clientService.createClient(c);
            System.out.println("Client created successfully: " + c.getName());
        } catch (Exception e) {
            System.out.println("Error creating client: " + e.getMessage());
        }
    }

    // ----------------- READ SINGLE -----------------
    public void getClientById(int id) {
        try {
            Client c = clientService.getClientById(id);
            System.out.println("Client: " + c.getName() + ", Industry: " + c.getIndustry());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------- READ ALL -----------------
    public void getAllClients() {
        try {
            List<Client> clients = clientService.getAllClients();
            for (Client c : clients) {
                System.out.println("ID: " + c.getId() + ", Name: " + c.getName() +
                        ", Contact: " + c.getContactPersonName());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------- UPDATE -----------------
    public void updateClient(Client c) {
        try {
            clientService.updateClient(c);
            System.out.println("Client updated successfully: " + c.getName());
        } catch (Exception e) {
            System.out.println("Error updating client: " + e.getMessage());
        }
    }

    // ----------------- DELETE -----------------
    public void deleteClient(int id) {
        try {
            clientService.deleteClient(id);
            System.out.println("Client deleted successfully, ID: " + id);
        } catch (Exception e) {
            System.out.println("Error deleting client: " + e.getMessage());
        }
    }

    /**
     * Controller method to find clients by upcoming project deadline
     */
    public void findClientsByUpcomingProjectDeadline(int daysUntilDeadline) {
        try {
            List<Client> clients = clientService.findClientsByUpcomingProjectDeadline(daysUntilDeadline);
            System.out.println("=====================================");
            System.out.println("Clients with projects ending in next " + daysUntilDeadline + " days:");
            for (Client c : clients) {
                System.out.println("Client ID: " + c.getId() + ", Name: " + c.getName() +
                        ", Contact: " + c.getContactPersonName() +
                        ", Email: " + c.getContactEmail());
            }
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("Error fetching clients: " + e.getMessage());
        }
    }
}

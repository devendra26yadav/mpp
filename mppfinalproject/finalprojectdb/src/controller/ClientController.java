package controller;


import model.Client;
import repository.ClientRepository;
import service.ClientService;
import java.util.List;
import java.util.Objects;

public class ClientController {

    private final ClientService clientService;

    public ClientController()  {
        try {
            ClientRepository clientRepository = new ClientRepository();
            this.clientService = new ClientService(clientRepository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void createClient(Client c) {
        try {
            clientService.createClient(c);
            System.out.println("Client created successfully: " + c.getName());
        } catch (Exception e) {
            System.out.println("Error creating client: " + e.getMessage());
        }
    }

    public Client getClientById(int id) {
        try {
            Client c = clientService.getClientById(id);
            System.out.println("Client: " + c.getName() + ", Industry: " + c.getIndustry());
            return c;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new Client();
        }
    }

    public void getAllClients() {
        try {
            List<Client> clients = clientService.getAllClients();

            System.out.println("Using StreamAPI");
            clients.stream()
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void updateClient(Client c) {
        try {
            clientService.updateClient(c);
            System.out.println("Client updated successfully: " + c.getName());
        } catch (Exception e) {
            System.out.println("Error updating client: " + e.getMessage());
        }
    }


    public void deleteClient(int id) {
        try {
            clientService.deleteClient(id);
            System.out.println("Client deleted successfully, ID: " + id);
        } catch (Exception e) {
            System.out.println("Error deleting client: " + e.getMessage());
        }
    }


    public void findClientsByUpcomingProjectDeadline(int daysUntilDeadline) {
        try {
            List<Client> clients = clientService.findClientsByUpcomingProjectDeadline(daysUntilDeadline);
            System.out.println("_____******_____");
            System.out.println("Clients with projects ending in next " + daysUntilDeadline + " days:");
            for (Client c : clients) {
                System.out.println("Client ID: " + c.getId() + ", Name: " + c.getName() +
                        ", Contact: " + c.getContactPersonName() +
                        ", Email: " + c.getContactEmail());
            }
            System.out.println("_____******_____");
        } catch (Exception e) {
            System.out.println("Error fetching clients: " + e.getMessage());
        }
    }
}

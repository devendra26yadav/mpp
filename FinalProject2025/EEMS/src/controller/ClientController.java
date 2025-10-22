package controller;

import model.Client;
import service.ClientService;

import java.util.List;

public class ClientController {
    private final ClientService clientService = new ClientService();

    public void showClientsWithProjectsEndingSoon(int days) {
        List<Client> clients = clientService.findClientsByUpcomingProjectDeadline(days);

        if (clients.isEmpty()) {
            System.out.println("No clients found with projects ending within " + days + " days.");
            return;
        }

        System.out.println("Clients with Projects Ending in " + days + " Days:");
        for (Client c : clients) {
            System.out.println(c.getName() + " | Industry: " + c.getIndustry() + " | Contact: " + c.getContactPersonName());
        }
    }
}


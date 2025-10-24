
import controller.ClientController;
import model.Client;
import java.util.Scanner;

public class ClientCLI {
    private static final ClientController clientController = new ClientController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCLIENT CRUD");
            System.out.println("1. Add Client");
            System.out.println("2. View Client By Id");
            System.out.println("3. View All Clients");
            System.out.println("4. Update Client");
            System.out.println("5. Delete Client");
            System.out.println("6. Go back");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();
            switch (choice) {
                case 1 -> addClient();
                case 2 -> viewClientById();
                case 3 -> viewAllClients();
                case 4 -> updateClient();
                case 5 -> deleteClient();
                case 6 -> { System.out.println("Exiting From Client CRUD... Goodbye!");
                    return; }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }


    private static void addClient() {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter industry: ");
        String industry = scanner.nextLine();
        System.out.print("Enter contact person name: ");
        String contactPerson = scanner.nextLine();
        System.out.print("Enter contact phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter contact email: ");
        String email = scanner.nextLine();

        Client client = new Client(0, name, industry, contactPerson, phone, email);
        clientController.createClient(client);
    }

    private  static void viewAllClients() {
      clientController.getAllClients();
    }

    private static void viewClientById() {
        System.out.print("\nEnter Client ID: ");
        int id = getIntInput();
        clientController.getClientById(id);
    }
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Enter again: ");
            }
        }
    }

    private static void updateClient() {
        System.out.print("Enter client ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Client existing = clientController.getClientById(id);
        if (existing == null) {
            System.out.println("Client not found!");
            return;
        }

        System.out.print("Enter new name (" + existing.getName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter new industry (" + existing.getIndustry() + "): ");
        String industry = scanner.nextLine();
        System.out.print("Enter new contact person (" + existing.getContactPersonName() + "): ");
        String contactPerson = scanner.nextLine();
        System.out.print("Enter new phone (" + existing.getContactPhone() + "): ");
        String phone = scanner.nextLine();
        System.out.print("Enter new email (" + existing.getContactEmail() + "): ");
        String email = scanner.nextLine();

        existing.setName(!name.isEmpty() ? name : existing.getName());
        existing.setIndustry(!industry.isEmpty() ? industry : existing.getIndustry());
        existing.setContactPersonName(!contactPerson.isEmpty() ? contactPerson : existing.getContactPersonName());
        existing.setContactPhone(!phone.isEmpty() ? phone : existing.getContactPhone());
        existing.setContactEmail(!email.isEmpty() ? email : existing.getContactEmail());

        clientController.updateClient(existing);
    }

    private static void deleteClient() {
        System.out.print("Enter client ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        clientController.deleteClient(id);
    }
}

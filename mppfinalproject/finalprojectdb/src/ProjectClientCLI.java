
import controller.ProjectClientController;
import model.ProjectClient;

import java.util.Scanner;

public class ProjectClientCLI {
    private static final ProjectClientController controller = new ProjectClientController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPROJECT-CLIENT CRUD");
            System.out.println("1. Add ProjectClient");
            System.out.println("2. View All ProjectClients");
            System.out.println("3. View By ProjectClients");
            System.out.println("4. Delete ProjectClient");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");

            try
            {
                int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addProjectClient();
                case 2 -> viewAllProjectClient();
                case 3-> getProjectClient();
                case 4 -> deleteProjectClient();
                case 5 -> {
                    System.out.println("Returning From Project Client");
                    return; }
                default -> System.out.println("Invalid choice!");
            }
            } catch (Exception e) {
                System.out.println("Invalid Format"+e.getMessage());
            }
        }
    }
    private static void getProjectClient(){
        int projectId = readInt("Enter Project ID: ");
        int clientId = readInt("Enter Client ID: ");
        var pc =controller.getProjectClient(projectId,clientId);
        if(pc!=null){
            System.out.println("Found As");
            System.out.println(pc);
        }else {
            System.out.println("No Project or Client Found");
        }
    }
    private static void viewAllProjectClient(){
        controller.getAllProjectClients();
    }
    private static void addProjectClient() {
        int projectId = readInt("Enter Project ID: ");
        int clientId = readInt("Enter Client ID: ");

        ProjectClient pc = new ProjectClient(projectId, clientId);
        controller.addProjectClient(pc);
    }

    private static void deleteProjectClient() {
        int projectId = readInt("Enter Project ID to delete: ");
        int clientId = readInt("Enter Client ID to delete: ");
        controller.deleteProjectClient(projectId, clientId);
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a number: ");
            }
        }
    }
}

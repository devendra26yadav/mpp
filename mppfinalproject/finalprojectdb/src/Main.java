
import controller.ClientController;
import controller.EmployeeController;
import controller.ProjectController;
import utils.DBConnection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            ProjectController projectController = new ProjectController();
            ClientController clientController = new ClientController();
            EmployeeController employeeController = new EmployeeController();
            while (true) {
                System.out.println("\nEMPLOYMENT MANAGEMENT SYSTEM(EMS)");
                System.out.println("1. Department Management (CRUD)");
                System.out.println("2. Employee Management (CRUD)");
                System.out.println("3. Client Management (CRUD)");
                System.out.println("4. Project Management (CRUD)");
                System.out.println("5. Run Business Logic Tasks");
                System.out.println("6. Department Project (CRUD)");
                System.out.println("7. Employee Project (CRUD)");
                System.out.println("8. Project Client (CRUD)");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> DepartmentCLI.main(null);
                    case 2 -> EmployeeCLI.main(null);
                    case 3 -> ClientCLI.main(null);
                    case 4 -> ProjectCLI.main(null);
                    case 5 -> runBusinessTasks(projectController, clientController, employeeController);
                    case 6-> DepartmentProjectCLI.main(null);
                    case 7-> EmployeeProjectCLI.main(null);
                    case 8-> ProjectClientCLI.main(null);
                    case 9 -> {
                        System.out.println("Exiting system. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
    }

private static void runBusinessTasks(ProjectController projectController,
                                     ClientController clientController,
                                     EmployeeController employeeController) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("\nBUSINESS LOGIC TASKS");
        System.out.println("1. Calculate Project HR Cost");
        System.out.println("2. Get Projects by Department");
        System.out.println("3. Find Clients by Upcoming Project Deadline");
        System.out.println("4. Transfer Employee to Another Department");
        System.out.println("5. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = readInt(scanner);

        switch (choice) {
            case 1 -> {
                // result for project id 1, 2
                System.out.println("\nTask 1: Calculate Project HR Cost");
                System.out.print("Enter Project ID (or 0 to skip): ");
                int projectId = readInt(scanner);
                if (projectId != 0) projectController.calculateProjectHRCost(projectId);
            }
            case 2 -> {
                // result will show for department id 1, etc
                System.out.println("\nTask 2: Get Projects by Department");
                System.out.print("Enter Department ID (or 0 to skip): ");
                int deptId = readInt(scanner);
                if (deptId != 0) {
                    System.out.print("Sort by field ('budget' or 'endDate'): ");
                    String sortBy = scanner.nextLine().trim();
                    if (!sortBy.equalsIgnoreCase("budget") && !sortBy.equalsIgnoreCase("endDate")) {
                        System.out.println("Invalid field! Defaulting to 'budget'.");
                        sortBy = "budget";
                    }
                    projectController.getProjectsByDepartment(deptId, sortBy);
                }
            }
            case 3 -> {
                // result will show for 30 , 60, 70
                System.out.println("\nTask 3: Find Clients by Upcoming Project Deadline ---");
                System.out.print("Enter number of days until deadline (or 0 to skip): ");
                int days = readInt(scanner);
                if (days != 0) clientController.findClientsByUpcomingProjectDeadline(days);
            }
            case 4 -> {
                // transfer can only be done if existing fields only e.g 1 to 2
                System.out.println("\nTask 4: Transfer Employee to Another Department");
                System.out.print("Enter Employee ID (or 0 to skip): ");
                int empId = readInt(scanner);
                if (empId != 0) {
                    System.out.print("Enter New Department ID: ");
                    int newDeptId = readInt(scanner);
                    employeeController.transferEmployeeToDepartment(empId, newDeptId);
                }
            }
            case 5 -> {
                System.out.println("Returning to Main Menu...");
                return;
            }
            default -> System.out.println("Invalid choice! Try again.");
        }
    }
}
    private static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a valid integer: ");
            }
        }
    }

}

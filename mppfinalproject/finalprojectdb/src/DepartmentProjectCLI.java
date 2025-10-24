
import controller.DepartmentProjectController;
import java.util.Scanner;

public class DepartmentProjectCLI {

    private static final DepartmentProjectController controller = new DepartmentProjectController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDEPARTMENT–PROJECT CRUD");
            System.out.println("1. Assign Project to Department");
            System.out.println("2. View All Assignments");
            System.out.println("3. View Projects by Department");
            System.out.println("4. View Departments by Project");
            System.out.println("5. Remove Assignment");
            System.out.println("6. Go Back");
            System.out.print("Enter your choice: ");

            String choiceStr = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number 1–6.");
                continue;
            }

            switch (choice) {
                case 1 -> assignProjectToDepartment();
                case 2 -> controller.getAllAssignments();
                case 3 -> viewProjectsByDepartment();
                case 4 -> viewDepartmentsByProject();
                case 5 -> removeAssignment();
                case 6 -> {
                    System.out.println("Exiting Department–Project CRUD...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void assignProjectToDepartment() {
        System.out.print("Enter Department ID: ");
        int departmentId = readIntInput();
        System.out.print("Enter Project ID: ");
        int projectId = readIntInput();

        controller.assignProjectToDepartment(departmentId, projectId);
    }

    private static void viewProjectsByDepartment() {
        System.out.print("Enter Department ID: ");
        int departmentId = readIntInput();
        controller.getAssignmentsByDepartment(departmentId);
    }

    private static void viewDepartmentsByProject() {
        System.out.print("Enter Project ID: ");
        int projectId = readIntInput();
        controller.getAssignmentsByProject(projectId);
    }

    private static void removeAssignment() {
        System.out.print("Enter Department ID: ");
        int departmentId = readIntInput();
        System.out.print("Enter Project ID: ");
        int projectId = readIntInput();

        controller.removeAssignment(departmentId, projectId);
    }

    private static int readIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Please enter a valid integer: ");
            }
        }
    }
}

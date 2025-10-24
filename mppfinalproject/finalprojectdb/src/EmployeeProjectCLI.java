import controller.EmployeeProjectController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeProjectCLI {

    private static final EmployeeProjectController employeeProjectController = new EmployeeProjectController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== EMPLOYEE-PROJECT MANAGEMENT =====");
            System.out.println("1. Assign Employee to Project");
            System.out.println("2. View All Assignments");
            System.out.println("3. Find Assignment by Employee");
            System.out.println("4. Update Employee Project Allocation");
            System.out.println("5. Delete Assignment");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> assignEmployeeToProject();
                case 2 -> viewAllAssignments();
                case 3 -> findAssignmentById();
                case 4 -> updateEmployeeProject();
                case 5 -> deleteAssignment();
                case 0 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private  static void assignEmployeeToProject() {
        System.out.println("\n--- Assign Employee to Project ---");

        int employeeId = readIntWithPrompt("Enter Employee ID: ");
        int projectId = readIntWithPrompt("Enter Project ID: ");
        double allocation = readDoubleWithPrompt("Enter Allocation Percentage (0-100): ");

        employeeProjectController.assignEmployeeToProject(employeeId,projectId,allocation);
    }


    private static void viewAllAssignments() {
        System.out.println("\n--- All Employee-Project Assignments ---");
       employeeProjectController.getAllAssignments();
    }

    private static void findAssignmentById() {
        System.out.println("\n--- Find Assignment ---");
        int employeeId = readIntWithPrompt("Enter Employee ID: ");

        employeeProjectController.getAssignmentsByEmployee(employeeId);

    }

    private static void updateEmployeeProject() {
        System.out.println("\n--- Update Employee Project Allocation ---");
        int employeeId = readIntWithPrompt("Enter Employee ID: ");
        int projectId = readIntWithPrompt("Enter Project ID: ");
        double newAllocation = readDoubleWithPrompt("Enter New Allocation Percentage (0-100): ");

        employeeProjectController.updateEmployeeProject(employeeId, projectId, newAllocation);
    }

    private static void deleteAssignment() {
        System.out.println("\n--- Delete Assignment ---");
        int employeeId = readIntWithPrompt("Enter Employee ID: ");
        int projectId = readIntWithPrompt("Enter Project ID: ");

        employeeProjectController.deleteAssignment(employeeId, projectId);
    }

    private static int readInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid number. Please enter again: ");
                scanner.nextLine();
            }
        }
    }

    private static int readIntWithPrompt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    private static double readDoubleWithPrompt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                if (value < 0 || value > 100) {
                    System.out.println("Allocation must be between 0 and 100.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a numeric value.");
                scanner.nextLine();
            }
        }
    }
}

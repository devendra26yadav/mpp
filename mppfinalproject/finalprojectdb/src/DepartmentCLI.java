import controller.DepartmentController;
import model.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentCLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DepartmentController controller = new DepartmentController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDEPARTMENT CRUD");
            System.out.println("1. Add Department");
            System.out.println("2. View All Departments");
            System.out.println("3. View Department by ID");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Department");
            System.out.println("6. Go back");
            System.out.print("Choose an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> addDepartment();
                case 2 -> viewAllDepartments();
                case 3 -> viewDepartmentById();
                case 4 -> updateDepartment();
                case 5 -> deleteDepartment();
                case 6 -> {
                    System.out.println("Exiting From Department CRUD... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static void addDepartment() {
        System.out.println("\n--- Add New Department ---");
        System.out.print("Enter department name: ");
        String name = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter annual budget: ");
        double budget = getDoubleInput();

        Department dept = new Department();
        dept.setName(name);
        dept.setLocation(location);
        dept.setAnnualBudget(budget);

        controller.createDepartment(dept);
        System.out.println("Department added successfully!");
    }

    private static void viewAllDepartments() {
        System.out.println("\n--- All Departments ---");
         controller.getAllDepartments();
    }

    private static void viewDepartmentById() {
        System.out.print("\nEnter Department ID: ");
        int id = getIntInput();
        controller.getDepartmentById(id);
    }

    private static void updateDepartment() {
        System.out.print("\nEnter Department ID to update: ");
        int id = getIntInput();
        Department dept = controller.getDepartmentById(id);

        if (dept == null) {
            System.out.println("Department not found!");
            return;
        }

        System.out.println("Current Data: " + dept);
        System.out.print("Enter new name (leave blank to keep same): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) dept.setName(name);

        System.out.print("Enter new location (leave blank to keep same): ");
        String location = scanner.nextLine();
        if (!location.isEmpty()) dept.setLocation(location);

        System.out.print("Enter new annual budget (-1 to keep same): ");
        double budget = getDoubleInput();
        if (budget >= 0) dept.setAnnualBudget(budget);

        controller.updateDepartment(dept);
        System.out.println("Department updated successfully!");
    }

    private static void deleteDepartment() {
        System.out.print("\nEnter Department ID to delete: ");
        int id = getIntInput();
        controller.deleteDepartment(id);

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

    private static double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Enter again: ");
            }
        }
    }
}

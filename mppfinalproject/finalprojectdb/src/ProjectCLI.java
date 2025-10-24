
import controller.ProjectController;
import model.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProjectCLI {
    private static final ProjectController projectController = new ProjectController();
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPROJECT CRUD");
            System.out.println("1. Add Project");
            System.out.println("2. View Project By Id");
            System.out.println("3. View All Projects");
            System.out.println("4. Update Project");
            System.out.println("5. Delete Project");
            System.out.println("6. Go Back");
            System.out.print("Enter your choice: ");

           try
           {
               int choice = Integer.parseInt(scanner.nextLine());
               switch (choice) {
                   case 1 -> addProject();
                   case 2->  viewDepartmentById();
                   case 3 -> viewAllProjects();
                   case 4 -> updateProject();
                   case 5 -> deleteProject();
                   case 6 -> {  System.out.println("Exiting From Project CRUD... Goodbye!");
                       return; }
                   default -> System.out.println("Invalid choice! Try again.");
               }
           } catch (Exception e) {
               System.out.println("Invalid "+e.getMessage());
           }
        }
    }

    private static void addProject() {
        try {
            System.out.print("Enter project name: ");
            String name = scanner.nextLine();

            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            System.out.print("Enter start date (yyyy-MM-dd): ");
            Date startDate = parseDate(scanner.nextLine());

            System.out.print("Enter end date (yyyy-MM-dd): ");
            Date endDate = parseDate(scanner.nextLine());

            System.out.print("Enter budget: ");
            double budget = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter status (Planned/Active/Completed/On Hold/Cancelled): ");
            String status = scanner.nextLine();

            Project project = new Project(0, name, description, startDate, endDate, budget, status);
            projectController.createProject(project);

        } catch (Exception e) {
            System.out.println("Error while adding project: " + e.getMessage());
        }
    }

    private static void viewAllProjects() {
        projectController.getAllProjects();
    }

    private static void viewDepartmentById() {
        System.out.print("\nEnter Project ID: ");
        int id = getIntInput();
        projectController.getProjectById(id);
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

    private static void updateProject() {
        System.out.print("Enter project ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Project existing = projectController.getProjectById(id);
        if (existing == null) {
            System.out.println("Project not found!");
            return;
        }

        try {
            System.out.print("Enter new name (" + existing.getName() + "): ");
            String name = scanner.nextLine();

            System.out.print("Enter new description (" + existing.getDescription() + "): ");
            String description = scanner.nextLine();

            System.out.print("Enter new start date (" + formatDate(existing.getStartDate()) + "): ");
            String startInput = scanner.nextLine();

            System.out.print("Enter new end date (" + formatDate(existing.getEndDate()) + "): ");
            String endInput = scanner.nextLine();

            System.out.print("Enter new budget (" + existing.getBudget() + "): ");
            String budgetInput = scanner.nextLine();

            System.out.print("Enter new status (" + existing.getStatus() + "): ");
            String status = scanner.nextLine();

            if (!name.isEmpty()) existing.setName(name);
            if (!description.isEmpty()) existing.setDescription(description);
            if (!startInput.isEmpty()) existing.setStartDate(parseDate(startInput));
            if (!endInput.isEmpty()) existing.setEndDate(parseDate(endInput));
            if (!budgetInput.isEmpty()) existing.setBudget(Double.parseDouble(budgetInput));
            if (!status.isEmpty()) existing.setStatus(status);

            projectController.updateProject(existing);

        } catch (Exception e) {
            System.out.println("Error updating project: " + e.getMessage());
        }
    }

    private static void deleteProject() {
        System.out.print("Enter project ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        projectController.deleteProject(id);
    }


    private static Date parseDate(String input) throws ParseException {
        if (input == null || input.isEmpty()) return null;
        return dateFormat.parse(input);
    }

    private static String formatDate(Date date) {
        return (date != null) ? dateFormat.format(date) : "N/A";
    }
}

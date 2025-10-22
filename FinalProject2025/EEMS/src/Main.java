import controller.*;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DepartmentController departmentController = new DepartmentController();
    private static final EmployeeController employeeController = new EmployeeController();
    private static final ProjectController projectController = new ProjectController();
    private static final ClientController clientController = new ClientController();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n______Employment Management System ______");
            System.out.println("1. List Departments");
            System.out.println("2. List Employees");
            System.out.println("3. Calculate Project HR Cost");
            System.out.println("4. List Active Projects by Department");
            System.out.println("5. Find Clients by Upcoming Project Deadline");
            System.out.println("6. Transfer Employee to Department");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    departmentController.listAllDepartments();
                    break;
                case 2:
                    employeeController.listAllEmployees();
                    break;
                case 3:
                    System.out.print("Enter Project ID: ");
                    int projectId = scanner.nextInt();
                    scanner.nextLine();
                    projectController.calculateProjectHRCost(projectId);
                    break;
                case 4:
                    System.out.print("Enter Department ID: ");
                    int deptId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Sort by (budget/endDate): ");
                    String sortBy = scanner.nextLine();
                    projectController.showActiveProjectsByDepartment(deptId, sortBy);
                    break;
                case 5:
                    System.out.print("Enter days until deadline: ");
                    int days = scanner.nextInt();
                    scanner.nextLine();
                    clientController.showClientsWithProjectsEndingSoon(days);
                    break;
                case 6:
                    System.out.print("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Department ID: ");
                    int newDeptId = scanner.nextInt();
                    scanner.nextLine();
                    employeeController.transferEmployee(empId, newDeptId);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        scanner.close();
    }
}

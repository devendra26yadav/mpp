package controller;

import model.Department;
import service.DepartmentService;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {

    private final DepartmentService service = new DepartmentService();
    private final Scanner scanner = new Scanner(System.in);

    public void createDepartment() {
        System.out.println("=== Create Department ===");
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter annual budget: ");
        double budget = Double.parseDouble(scanner.nextLine());

        Department department = new Department(id, name, location, budget);
        service.createDepartment(department);
    }

    public void listAllDepartments() {
        List<Department> departments = service.getAllDepartments();
        System.out.println("=== Departments List ===");
        for (Department dept : departments) {
            System.out.println(dept);
        }
    }

    public void updateDepartment() {
        System.out.println("=== Update Department ===");
        System.out.print("Enter Department ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Department department = service.getDepartment(id);
        if (department == null) {
            System.out.println("Department not found.");
            return;
        }

        System.out.print("Enter new name (" + department.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isBlank()) {
            department.setName(name);
        }

        System.out.print("Enter new location (" + department.getLocation() + "): ");
        String location = scanner.nextLine();
        if (!location.isBlank()) {
            department.setLocation(location);
        }

        System.out.print("Enter new annual budget (" + department.getAnnualBudget() + "): ");
        String budgetStr = scanner.nextLine();
        if (!budgetStr.isBlank()) {
            department.setAnnualBudget(Double.parseDouble(budgetStr));
        }

        service.updateDepartment(department);
    }

    public void deleteDepartment() {
        System.out.println("=== Delete Department ===");
        System.out.print("Enter Department ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        service.deleteDepartment(id);
    }
}

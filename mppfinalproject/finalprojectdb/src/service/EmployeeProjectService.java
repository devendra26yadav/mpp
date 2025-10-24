package service;

import model.EmployeeProject;
import repository.EmployeeProjectRepository;
import java.util.List;

public class EmployeeProjectService {
    private final EmployeeProjectRepository repository = new EmployeeProjectRepository();

    public void assignEmployeeToProject(EmployeeProject ep) {
        if (repository.add(ep)) {
            System.out.println("Employee assigned successfully!");
        } else {
            System.out.println("Failed to assign employee.");
        }
    }

    public void viewAllAssignments() {
        List<EmployeeProject> list = repository.getAll();
        if (list.isEmpty()) {
            System.out.println("No Employee–Project assignments found.");
            return;
        }
        list.forEach(System.out::println);
    }

    public void viewAssignmentsByEmployee(int employeeId) {
        List<EmployeeProject> list = repository.getByEmployeeId(employeeId);
        if (list.isEmpty()) {
            System.out.println("No projects found for employee ID " + employeeId);
            return;
        }
        System.out.println("Found: ");
        list.forEach(System.out::println);
    }

    public void removeAssignment(int employeeId, int projectId) {
        if (repository.delete(employeeId, projectId)) {
            System.out.println("Assignment removed successfully!");
        } else {
            System.out.println("Failed to remove assignment.");
        }
    }

    public void updateEmployeeProject(EmployeeProject ep) {
        if (ep.getAllocationPercentage() < 0 || ep.getAllocationPercentage() > 100) {
            throw new IllegalArgumentException("Allocation percentage must be between 0 and 100.");
        }
        repository.update(ep);
    }
}

package service;

import repository.DepartmentProjectRepository;
import java.util.List;

public class DepartmentProjectService {
    private final DepartmentProjectRepository repo;

    public DepartmentProjectService() {
        this.repo = new DepartmentProjectRepository();
    }

    public void addAssignment(int departmentId, int projectId) {
        boolean success = repo.addAssignment(departmentId, projectId);
        if (!success) {
            System.out.println("Failed to add assignment. Check if Department and Project IDs exist or are already linked.");
        }
    }

    public void getAllAssignments() {
        List<String> list = repo.getAllAssignments();
        if (list.isEmpty()) {
            System.out.println("No assignments found.");
        } else {
            System.out.println("\nAll Department-Project Assignments");
            list.stream()
                    .forEach(System.out::println);
        }
    }

    public void getAssignmentsByDepartment(int departmentId) {
        List<String> projects = repo.getAssignmentsByDepartment(departmentId);

        if (projects.isEmpty()) {
            System.out.println("No projects assigned.");
        } else {
            System.out.println("\nProjects for Department ID " + departmentId + ":");
            projects.forEach(System.out::println);
        }
    }

    public void getAssignmentsByProject(int projectId) {
        List<String> departments = repo.getAssignmentsByProject(projectId);

        if (departments.isEmpty()) {
            System.out.println("No departments assigned.");
        } else {
            System.out.println("\nDepartments for Project ID " + projectId + ":");
            departments.forEach(System.out::println);
        }
    }

    public void removeAssignment(int departmentId, int projectId) {
        repo.removeAssignment(departmentId, projectId);
    }
}

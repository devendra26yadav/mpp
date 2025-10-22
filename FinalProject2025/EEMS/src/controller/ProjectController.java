package controller;

import model.Project;
import service.ProjectService;

import java.util.List;

public class ProjectController {
    private final ProjectService projectService = new ProjectService();

    public void calculateProjectHRCost(int projectId) {
        double cost = projectService.calculateProjectHRCost(projectId);
        System.out.println("Project HR Cost (ID " + projectId + "): $" + cost);
    }

    // Later you can add methods like:
    // - createProject()
    // - listProjects()
    // - assignEmployeesToProject()
    public void showActiveProjectsByDepartment(int departmentId, String sortBy) {
        List<Project> projects = projectService.getProjectsByDepartment(departmentId, sortBy);

        if (projects.isEmpty()) {
            System.out.println("No active projects found for Department ID: " + departmentId);
            return;
        }

        System.out.println("Active Projects for Department ID " + departmentId + " (Sorted by " + sortBy + "):");
        for (Project p : projects) {
            System.out.println("#" + p.getName() + " | Budget: $" + p.getBudgetAmount() + " | Ends: " + p.getEndDate());
        }
    }
}

package controller;


import model.Project;
import repository.ProjectRepository;
import service.ProjectService;

import java.util.List;

public class ProjectController {

    private final ProjectService projectService;

    // ----------------- CREATE -----------------
    public void createProject(Project p) {
        try {
            projectService.createProject(p);
            System.out.println("Project created successfully: " + p.getName());
        } catch (Exception e) {
            System.out.println("Error creating project: " + e.getMessage());
        }
    }

    // ----------------- READ SINGLE -----------------
    public void getProjectById(int id) {
        try {
            Project p = projectService.getProjectById(id);
            System.out.println("Project: " + p.getName() + ", Status: " + p.getStatus());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------- READ ALL -----------------
    public void getAllProjects() {
        try {
            List<Project> projects = projectService.getAllProjects();
            for (Project p : projects) {
                System.out.println("ID: " + p.getId() + ", Name: " + p.getName() +
                        ", Budget: " + p.getBudget());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------- UPDATE -----------------
    public void updateProject(Project p) {
        try {
            projectService.updateProject(p);
            System.out.println("Project updated successfully: " + p.getName());
        } catch (Exception e) {
            System.out.println("Error updating project: " + e.getMessage());
        }
    }

    // ----------------- DELETE -----------------
    public void deleteProject(int id) {
        try {
            projectService.deleteProject(id);
            System.out.println("Project deleted successfully, ID: " + id);
        } catch (Exception e) {
            System.out.println("Error deleting project: " + e.getMessage());
        }
    }

    // Constructor initializes Repository + Service internally
    public ProjectController() throws Exception {
        ProjectRepository projectRepository = new ProjectRepository(); // handles DB connection
        this.projectService = new ProjectService(projectRepository);
    }

    // Method to calculate HR cost
    public void calculateProjectHRCost(int projectId) {
        try {
            double cost = projectService.calculateProjectHRCost(projectId);
            System.out.println("=====================================");
            System.out.println("Project HR Cost for project ID " + projectId + ": $" + cost);
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("Error calculating HR cost: " + e.getMessage());
        }
    }

    // You can add other controller methods here for future service tasks
    /**
     * Controller method to get all active projects by department and sort
     */
    public void getProjectsByDepartment(int departmentId, String sortBy) {
        try {
            List<Project> projects = projectService.getProjectsByDepartment(departmentId, sortBy);
            System.out.println("=====================================");
            System.out.println("Active projects for Department ID " + departmentId + " sorted by " + sortBy + ":");
            for (Project p : projects) {
                System.out.println("Project ID: " + p.getId() + ", Name: " + p.getName() +
                        ", Budget: $" + p.getBudget() + ", End Date: " + p.getEndDate());
            }
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("Error fetching projects: " + e.getMessage());
        }
    }
}

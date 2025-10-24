package controller;


import model.Project;
import repository.ProjectRepository;
import service.ProjectService;

import java.util.List;
import java.util.Objects;

public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(){
        try {
            ProjectRepository projectRepository = new ProjectRepository(); // handles DB connection
            this.projectService = new ProjectService(projectRepository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void createProject(Project p) {
        try {
            projectService.createProject(p);
            System.out.println("Project created successfully: " + p.getName());
        } catch (Exception e) {
            System.out.println("Error creating project: " + e.getMessage());
        }
    }

    public Project getProjectById(int id) {
        try {
            Project p = projectService.getProjectById(id);
            System.out.println("Project: " + p.getName() + ", Status: " + p.getStatus());
            return p;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new Project();
        }
    }

    public void getAllProjects() {
        try {
            List<Project> projects = projectService.getAllProjects();
            System.out.println("Using StreamAPI");
            projects.stream()
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void updateProject(Project p) {
        try {
            projectService.updateProject(p);
            System.out.println("Project updated successfully: " + p.getName());
        } catch (Exception e) {
            System.out.println("Error updating project: " + e.getMessage());
        }
    }


    public void deleteProject(int id) {
        try {
            projectService.deleteProject(id);
            System.out.println("Project deleted successfully, ID: " + id);
        } catch (Exception e) {
            System.out.println("Error deleting project: " + e.getMessage());
        }
    }



    // Method to calculate HR cost
    public void calculateProjectHRCost(int projectId) {
        try {
            double cost = projectService.calculateProjectHRCost(projectId);
            System.out.println("--------------------------------");
            System.out.printf("Project HR Cost for project ID " + projectId + ": $%.2f\n" ,cost);
            System.out.println("----------------------------------");
        } catch (Exception e) {
            System.out.println("Error calculating HR cost: " + e.getMessage());
        }
    }


    public void getProjectsByDepartment(int departmentId, String sortBy) {
        try {
            List<Project> projects = projectService.getProjectsByDepartment(departmentId, sortBy);

            if(!projects.isEmpty()){
                System.out.println("----------------------------------");
                System.out.println("Active projects for Department ID " + departmentId + " sorted by " + sortBy + ":");
                for (Project p : projects) {
                    System.out.println("Project ID: " + p.getId() + ", Name: " + p.getName() +
                            ", Budget: $" + p.getBudget() + ", End Date: " + p.getEndDate());
                }
                System.out.println("---------------------------------------");
            }else{
                System.out.println("No Active Project Found Under this Department");
            }

        } catch (Exception e) {
            System.out.println("Error fetching projects: " + e.getMessage());
        }
    }
}

package controller;

import model.EmployeeProject;
import service.EmployeeProjectService;

public class EmployeeProjectController {
    private final EmployeeProjectService service = new EmployeeProjectService();

    public void assignEmployeeToProject(int employeeId, int projectId, double allocationPercentage) {
        EmployeeProject ep = new EmployeeProject(employeeId, projectId, allocationPercentage);
        service.assignEmployeeToProject(ep);
    }

    public void getAllAssignments() {
        service.viewAllAssignments();
    }

    public void getAssignmentsByEmployee(int employeeId) {
        service.viewAssignmentsByEmployee(employeeId);
    }

    public void deleteAssignment(int employeeId, int projectId) {
        service.removeAssignment(employeeId, projectId);
    }
    public void updateEmployeeProject(int employeeId, int projectId, double allocationPercentage) {
        try {
            EmployeeProject ep = new EmployeeProject(employeeId, projectId, allocationPercentage);
            service.updateEmployeeProject(ep);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}

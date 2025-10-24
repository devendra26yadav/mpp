package controller;

import service.DepartmentProjectService;

public class DepartmentProjectController {
    private final DepartmentProjectService service;

    public DepartmentProjectController() {
        this.service = new DepartmentProjectService();
    }

    public void assignProjectToDepartment(int departmentId, int projectId) {
        service.addAssignment(departmentId, projectId);
    }

    public void getAllAssignments() {
        service.getAllAssignments();
    }

    public void getAssignmentsByDepartment(int departmentId) {
        service.getAssignmentsByDepartment(departmentId);
    }

    public void getAssignmentsByProject(int projectId) {
        service.getAssignmentsByProject(projectId);
    }

    public void removeAssignment(int departmentId, int projectId) {
        service.removeAssignment(departmentId, projectId);
    }
}

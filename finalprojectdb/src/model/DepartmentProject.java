package model;

public class DepartmentProject {
    private int departmentId;
    private int projectId;

    private Department department;
    private Project project;

    public DepartmentProject() {}

    public DepartmentProject(int departmentId, int projectId) {
        this.departmentId = departmentId;
        this.projectId = projectId;
    }

    // Getters and Setters
    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}

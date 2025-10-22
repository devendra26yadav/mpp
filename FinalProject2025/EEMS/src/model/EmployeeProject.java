package model;

//EmployeeProject (Junction Table)

public class EmployeeProject {
    private int employeeId;
    private int projectId;
    private double allocationPercentage;
    //Justification: Resolves M:N between Employee and Project, tracks allocation.
}

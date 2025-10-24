package model;

import java.sql.Date;
import java.util.List;

public class Employee {
    private int id;
    private String fullName;
    private String title;
    private Date hireDate;
    private double salary;
    private int departmentId;
    private Integer managerId; // nullable

    // Relationships
    private Department department;
    private Employee manager;
    private List<EmployeeProject> projectAllocations;

    public Employee() {}

    public Employee(int id, String fullName, String title, Date hireDate, double salary, int departmentId) {
        this.id = id;
        this.fullName = fullName;
        this.title = title;
        this.hireDate = hireDate;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public Integer getManagerId() { return managerId; }
    public void setManagerId(Integer managerId) { this.managerId = managerId; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }

    public List<EmployeeProject> getProjectAllocations() { return projectAllocations; }
    public void setProjectAllocations(List<EmployeeProject> projectAllocations) { this.projectAllocations = projectAllocations; }

    @Override
    public String toString() {
        return "{id=" + id + ", fullName='" + fullName + "', title='" + title +
                "', salary=" + salary + ", departmentId=" + departmentId + "}";
    }
}

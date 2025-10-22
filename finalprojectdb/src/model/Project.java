package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private double budget;
    private String status;

    // Relationships
    private List<EmployeeProject> employeeAllocations = new ArrayList<>();
    private List<Department> departments=new ArrayList<>();
    private List<Client> clients=new ArrayList<>();

    public Project() {}

    public Project(int id, String name, String description, Date startDate, Date endDate, double budget, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<EmployeeProject> getEmployeeAllocations() { return employeeAllocations; }
    public void setEmployeeAllocations(List<EmployeeProject> employeeAllocations) { this.employeeAllocations = employeeAllocations; }

    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }

    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }

    @Override
    public String toString() {
        return "Project{id=" + id + ", name='" + name + "', budget=" + budget + ", status='" + status + "'}";
    }
}

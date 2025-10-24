package service;

import model.EmployeeProject;
import model.Project;
import repository.ProjectRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // ----------------- CREATE -----------------
    public void createProject(Project project) throws Exception {
        if (project.getBudget() < 0) throw new Exception("Project budget cannot be negative");
        projectRepository.createProject(project);
    }

    // ----------------- READ SINGLE -----------------
    public Project getProjectById(int id) throws Exception {
        Project p = projectRepository.getProjectById(id);
        if (p == null) throw new Exception("Project not found");
        return p;
    }

    // ----------------- READ ALL -----------------
    public List<Project> getAllProjects() throws Exception {
        return projectRepository.getAllProjects();
    }

    // ----------------- UPDATE -----------------
    public void updateProject(Project project) throws Exception {
        Project existing = projectRepository.getProjectById(project.getId());
        if (existing == null) throw new Exception("Project not found");
        projectRepository.updateProject(project);
    }

    // ----------------- DELETE -----------------
    public void deleteProject(int id) throws Exception {
        Project existing = projectRepository.getProjectById(id);
        if (existing == null) throw new Exception("Project not found");
        projectRepository.deleteProject(id);
    }



    public double calculateProjectHRCost(int projectId) throws Exception {

        // 1. getting project
        Project project = projectRepository.getProjectById(projectId);
        if (project == null) {
            throw new Exception("Project not found with ID: " + projectId);
        }

        // 2. Calculate project duration in months (round up)
        int durationMonths = calculateMonthsBetween(project.getStartDate(), project.getEndDate());

        // 3. Retrieve employee allocations for this project
        List<EmployeeProject> allocations = project.getEmployeeAllocations();

        // 4. Compute weighted cost for each employee
        double totalCost = 0.0;
        for (EmployeeProject ep : allocations) {
            double salary = ep.getEmployee().getSalary();
            double allocation = ep.getAllocationPercentage();
            double employeeCost = (salary / 12.0) * durationMonths * (allocation / 100.0);
            totalCost += employeeCost;
        }

        return totalCost;
    }


    private int calculateMonthsBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) return 0;

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        int yearDiff = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        int monthDiff = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        // +1 to round up partial month
        int totalMonths = yearDiff * 12 + monthDiff + 1;

        return Math.max(totalMonths, 0);
    }

    public List<Project> getProjectsByDepartment(int departmentId, String sortBy) throws Exception {
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "endDate";
        }

        return projectRepository.getProjectsByDepartment(departmentId, sortBy);
    }


}

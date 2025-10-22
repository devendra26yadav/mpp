package service;

import model.Project;
import repository.ProjectRepository;
import model.Employee;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository = new ProjectRepository();

    public double calculateProjectHRCost(int projectId) {
        try {
            // Get project dates
            LocalDate startDate = projectRepository.getProjectStartDate(projectId);
            LocalDate endDate = projectRepository.getProjectEndDate(projectId);

            // Duration in months (rounded up)
            long days = ChronoUnit.DAYS.between(startDate, endDate);
            int months = (int) Math.ceil(days / 30.0);

            // Get all employees assigned to project with allocation %
            List<Employee> employees = projectRepository.getEmployeesByProject(projectId);

            double totalCost = 0;

            for (Employee e : employees) {
                double monthlySalary = e.getSalary() / 12.0;
                double cost = monthlySalary * months * (e.getAllocationPercent() / 100.0);
                totalCost += cost;
            }

            return totalCost;

        } catch (Exception e) {
            //e.printStackTrace();
            //throw new RuntimeException("Failed to calculate HR cost.");
            System.out.println(e.getMessage());
            return 0.0;
        }
    }
    public List<Project> getProjectsByDepartment(int departmentId, String sortBy) {
        try {
            return projectRepository.getActiveProjectsByDepartment(departmentId, sortBy);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching department projects.");
        }
    }
}

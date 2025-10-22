package repository;

import model.Employee;
import model.Project;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    public LocalDate getProjectStartDate(int projectId) throws SQLException {
        String sql = "SELECT startDate FROM Project WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDate("startDate").toLocalDate();
            } else {
                throw new SQLException("Project not found.");
            }
        }
    }

    public LocalDate getProjectEndDate(int projectId) throws SQLException {
        String sql = "SELECT endDate FROM Project WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDate("endDate").toLocalDate();
            } else {
                throw new SQLException("Project not found.");
            }
        }
    }

    public List<Employee> getEmployeesByProject(int projectId) throws SQLException {
        String sql = """
        SELECT e.id, e.fullName, e.title, e.hireDate, e.salary, ep.allocationPercentage, e.departmentId
        FROM Employee e
        JOIN EmployeeProject ep ON e.id = ep.employeeId
        WHERE ep.projectId = ?
    """;

        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("title"),
                        rs.getDate("hireDate").toLocalDate(),
                        rs.getDouble("salary"),
                        rs.getInt("departmentId")
                );
                e.setAllocationPercent(rs.getDouble("allocationPercentage")); // You need to add this field
                employees.add(e);
            }
        }

        return employees;
    }

    public List<Project> getActiveProjectsByDepartment(int departmentId, String sortBy) throws SQLException {
        List<Project> projects = new ArrayList<>();

        // Validate sortBy field (protect against SQL injection)
        List<String> allowedSortFields = List.of("budget", "endDate", "startDate", "name");
        if (!allowedSortFields.contains(sortBy)) {
            throw new IllegalArgumentException("Invalid sort field: " + sortBy);
        }

        String sql = " SELECT p.id, p.name, p.description, p.startDate, p.endDate, p.budget, p.status FROM Project p "+
            " JOIN DepartmentProject dp ON p.id = dp.projectId "
            +" WHERE dp.departmentId = ? AND p.status = 'Active' ORDER BY " +sortBy;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, departmentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Project p = new Project();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setStartDate(rs.getDate("startDate").toLocalDate());
                p.setEndDate(rs.getDate("endDate").toLocalDate());
                p.setBudgetAmount(rs.getDouble("budget"));
                p.setStatus(rs.getString("status"));
                projects.add(p);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return projects;
    }

}

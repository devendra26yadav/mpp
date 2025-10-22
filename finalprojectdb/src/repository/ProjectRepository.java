package repository;

import model.Employee;
import model.EmployeeProject;
import model.Project;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private final Connection connection;

    public ProjectRepository() throws SQLException {
        this.connection = DBConnection.getConnection(); // use the utils class
    }

    /**
     * Fetch project by ID including employee allocations.
     */
    public Project getProjectById(int projectId) throws SQLException {
        Project project = null;

        String projectSql = "SELECT id, name, description, startDate, endDate, budget, status " +
                "FROM Project WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(projectSql)) {
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("startDate"));
                project.setEndDate(rs.getDate("endDate"));
                project.setBudget(rs.getDouble("budget"));
                project.setStatus(rs.getString("status"));
            }
        }

        if (project != null) {
            project.setEmployeeAllocations(getEmployeeProjectsByProjectId(projectId));
        }

        return project;
    }

    /**
     * Fetch all EmployeeProject records for a given project.
     */
    private List<EmployeeProject> getEmployeeProjectsByProjectId(int projectId) throws SQLException {
        List<EmployeeProject> allocations = new ArrayList<>();

        String sql = "SELECT ep.employeeId, ep.projectId, ep.allocationPercentage, " +
                "e.id AS empId, e.fullName, e.title, e.hireDate, e.salary, e.departmentId " +
                "FROM EmployeeProject ep " +
                "JOIN Employee e ON ep.employeeId = e.id " +
                "WHERE ep.projectId = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Employee
                Employee employee = new Employee();
                employee.setId(rs.getInt("empId"));
                employee.setFullName(rs.getString("fullName"));
                employee.setTitle(rs.getString("title"));
                employee.setHireDate(rs.getDate("hireDate"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartmentId(rs.getInt("departmentId"));

                // EmployeeProject
                EmployeeProject ep = new EmployeeProject();
                ep.setEmployeeId(rs.getInt("employeeId"));
                ep.setProjectId(rs.getInt("projectId"));
                ep.setAllocationPercentage(rs.getDouble("allocationPercentage"));
                ep.setEmployee(employee);

                allocations.add(ep);
            }
        }

        return allocations;
    }

    /**
     * Fetch all active projects for a department, sorted by a given field
     */
    public List<Project> getProjectsByDepartment(int departmentId, String sortBy) throws SQLException {
        List<Project> projects = new ArrayList<>();

        // Validate sortBy field to prevent SQL injection
        if (!sortBy.equalsIgnoreCase("budget") && !sortBy.equalsIgnoreCase("endDate") &&
                !sortBy.equalsIgnoreCase("startDate") && !sortBy.equalsIgnoreCase("name")) {
            sortBy = "endDate"; // fallback default
        }

        String sql = "SELECT p.id, p.name, p.description, p.startDate, p.endDate, p.budget, p.status " +
                "FROM Project p " +
                "JOIN DepartmentProject dp ON p.id = dp.projectId " +
                "WHERE dp.departmentId = ? AND p.status = 'Active' " +
                "ORDER BY " + sortBy;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setStartDate(rs.getDate("startDate"));
                project.setEndDate(rs.getDate("endDate"));
                project.setBudget(rs.getDouble("budget"));
                project.setStatus(rs.getString("status"));

                projects.add(project);
            }
        }

        return projects;
    }
    // ----------------- CREATE -----------------
    public void createProject(Project project) throws SQLException {
        String sql = "INSERT INTO Project (id, name, description, startDate, endDate, budget, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, project.getId());
            ps.setString(2, project.getName());
            ps.setString(3, project.getDescription());
            ps.setDate(4, new Date(project.getStartDate().getTime()));
            ps.setDate(5, new Date(project.getEndDate().getTime()));
            ps.setDouble(6, project.getBudget());
            ps.setString(7, project.getStatus());
            ps.executeUpdate();
        }
    }


    // ----------------- READ ALL -----------------
    public List<Project> getAllProjects() throws SQLException {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM Project";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setStartDate(rs.getDate("startDate"));
                p.setEndDate(rs.getDate("endDate"));
                p.setBudget(rs.getDouble("budget"));
                p.setStatus(rs.getString("status"));
                projects.add(p);
            }
        }
        return projects;
    }

    // ----------------- UPDATE -----------------
    public void updateProject(Project project) throws SQLException {
        String sql = "UPDATE Project SET name = ?, description = ?, startDate = ?, endDate = ?, budget = ?, status = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, project.getName());
            ps.setString(2, project.getDescription());
            ps.setDate(3, new Date(project.getStartDate().getTime()));
            ps.setDate(4, new Date(project.getEndDate().getTime()));
            ps.setDouble(5, project.getBudget());
            ps.setString(6, project.getStatus());
            ps.setInt(7, project.getId());
            ps.executeUpdate();
        }
    }

    // ----------------- DELETE -----------------
    public void deleteProject(int id) throws SQLException {
        // Delete from junction tables first
        String deleteEmployeeProject = "DELETE FROM EmployeeProject WHERE projectId = ?";
        String deleteDepartmentProject = "DELETE FROM DepartmentProject WHERE projectId = ?";
        try (PreparedStatement ps1 = connection.prepareStatement(deleteEmployeeProject);
             PreparedStatement ps2 = connection.prepareStatement(deleteDepartmentProject)) {
            ps1.setInt(1, id);
            ps1.executeUpdate();
            ps2.setInt(1, id);
            ps2.executeUpdate();
        }

        // Delete the project
        String sql = "DELETE FROM Project WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No project found with ID: " + id);
            }
        }
    }
}

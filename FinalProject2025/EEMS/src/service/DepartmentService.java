package service;

import model.Department;
import repository.DepartmentRepository;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    private final DepartmentRepository repository = new DepartmentRepository();

    public void createDepartment(Department department) {
        try {
            repository.create(department);
            System.out.println("Department created successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to create department: " + e.getMessage());
        }
    }

    public Department getDepartment(int id) {
        try {
            return repository.read(id);
        } catch (SQLException e) {
            System.err.println("Failed to read department: " + e.getMessage());
            return null;
        }
    }

    public List<Department> getAllDepartments() {
        try {
            return repository.readAll();
        } catch (SQLException e) {
            System.err.println("Failed to read departments: " + e.getMessage());
            return List.of();
        }
    }

    public void updateDepartment(Department department) {
        try {
            repository.update(department);
            System.out.println("Department updated successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to update department: " + e.getMessage());
        }
    }

    public void deleteDepartment(int id) {
        try {
            repository.delete(id);
            System.out.println("Department deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to delete department: " + e.getMessage());
        }
    }
}

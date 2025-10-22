package controller;

import model.Department;
import repository.DepartmentRepository;
import service.DepartmentService;

import java.util.List;

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController() throws Exception {
        DepartmentRepository repository = new DepartmentRepository();
        this.departmentService = new DepartmentService(repository);
    }

    // ----------------- CREATE -----------------
    public void createDepartment(Department dept) {
        try {
            departmentService.createDepartment(dept);
            System.out.println("Department created successfully: " + dept.getName());
        } catch (Exception ex) {
            System.out.println("Error creating department: " + ex.getMessage());
        }
    }

    // ----------------- READ SINGLE -----------------
    public void getDepartmentById(int id) {
        try {
            Department d = departmentService.getDepartmentById(id);
            System.out.println("Department: " + d.getName() + ", Location: " + d.getLocation());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // ----------------- READ ALL -----------------
    public void getAllDepartments() {
        try {
            List<Department> departments = departmentService.getAllDepartments();
            for (Department d : departments) {
                System.out.println("ID: " + d.getId() + ", Name: " + d.getName() +
                        ", Budget: " + d.getAnnualBudget());
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // ----------------- UPDATE -----------------
    public void updateDepartment(Department dept) {
        try {
            departmentService.updateDepartment(dept);
            System.out.println("Department updated successfully: " + dept.getName());
        } catch (Exception ex) {
            System.out.println("Error updating department: " + ex.getMessage());
        }
    }

    // ----------------- DELETE -----------------
    public void deleteDepartment(int id) {
        try {
            departmentService.deleteDepartment(id);
            System.out.println("Department deleted successfully, ID: " + id);
        } catch (Exception ex) {
            System.out.println("Error deleting department: " + ex.getMessage());
        }
    }
}

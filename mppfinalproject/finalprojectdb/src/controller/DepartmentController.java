package controller;

import model.Department;
import repository.DepartmentRepository;
import service.DepartmentService;

import java.util.List;
import java.util.Objects;

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(){
        try
        {
            DepartmentRepository repository = new DepartmentRepository();
            this.departmentService = new DepartmentService(repository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createDepartment(Department dept) {
        try {
            departmentService.createDepartment(dept);
            System.out.println("Department created successfully: " + dept.getName());
        } catch (Exception ex) {
            System.out.println("Error creating department: " + ex.getMessage());
        }
    }


    public Department getDepartmentById(int id) {
        try {
            Department d = departmentService.getDepartmentById(id);
            System.out.println("Department: " + d.getName() + ", Location: " + d.getLocation());
            return d;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return new Department();
        }
    }

    public void getAllDepartments() {
        try {
            List<Department> departments = departmentService.getAllDepartments();

            System.out.println("Using StreamAPI");
            departments.stream()
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void updateDepartment(Department dept) {
        try {
            departmentService.updateDepartment(dept);
            System.out.println("Department updated successfully: " + dept.getName());
        } catch (Exception ex) {
            System.out.println("Error updating department: " + ex.getMessage());
        }
    }


    public void deleteDepartment(int id) {
        try {
            departmentService.deleteDepartment(id);
            System.out.println("Department deleted successfully, ID: " + id);
        } catch (Exception ex) {
            System.out.println("Error deleting department: " + ex.getMessage());
        }
    }
}

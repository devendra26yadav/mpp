package service;


import model.Department;
import repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public void createDepartment(Department dept) throws Exception {
        if (dept.getAnnualBudget() < 0) throw new Exception("Budget cannot be negative");
        departmentRepository.createDepartment(dept);
    }


    public Department getDepartmentById(int id) throws Exception {
        Department d = departmentRepository.getDepartmentById(id);
        if (d == null) throw new Exception("Department not found");
        return d;
    }

    public List<Department> getAllDepartments() throws Exception {
        return departmentRepository.getAllDepartments();
    }

    public void updateDepartment(Department dept) throws Exception {
        Department existing = departmentRepository.getDepartmentById(dept.getId());
        if (existing == null) throw new Exception("Department not found");
        departmentRepository.updateDepartment(dept);
    }

    public void deleteDepartment(int id) throws Exception {
        Department existing = departmentRepository.getDepartmentById(id);
        if (existing == null) throw new Exception("Department not found");
        departmentRepository.deleteDepartment(id);
    }
}

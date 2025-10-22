package model;

import java.time.LocalDate;

//Justification: Tracks individual employees.
public class Employee {
    private int id;
    private String fullName;
    private String title;
    private LocalDate hireDate;
    private double salary;
    private int departmentId;// FK

    //added later
    private double allocationPercent;
    public Employee() {}

    public Employee(int id, String fullName, String title, LocalDate hireDate, double salary, int departmentId) {
        this.id = id;
        this.fullName = fullName;
        this.title = title;
        this.hireDate = hireDate;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public double getAllocationPercent() {
        return allocationPercent;
    }

    public void setAllocationPercent(double allocationPercent) {
        this.allocationPercent = allocationPercent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", title='" + title + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }
}

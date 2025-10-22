package repository;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private static final Connection conn=DBConnection.getConnection();

    public void save(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employee (id, fullName, title, hireDate, salary, departmentId) VALUES (?, ?, ?, ?, ?, ?)";
        if(conn!=null){
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, employee.getId());
                stmt.setString(2, employee.getFullName());
                stmt.setString(3, employee.getTitle());
                stmt.setDate(4, Date.valueOf(employee.getHireDate()));
                stmt.setDouble(5, employee.getSalary());
                stmt.setInt(6, employee.getDepartmentId());

                stmt.executeUpdate();
            }
        }

    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

       if(conn!=null){
           try (PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
               while (rs.next()) {
                   Employee e = new Employee(
                           rs.getInt("id"),
                           rs.getString("fullName"),
                           rs.getString("title"),
                           rs.getDate("hireDate").toLocalDate(),
                           rs.getDouble("salary"),
                           rs.getInt("departmentId")
                   );
                   employees.add(e);
               }
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
       }

        return employees;
    }

    public void update(Employee employee) throws SQLException {
        String sql = "UPDATE Employee SET fullName=?, title=?, hireDate=?, salary=?, departmentId=? WHERE id=?";

       if(conn!=null){
           try (PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setString(1, employee.getFullName());
               stmt.setString(2, employee.getTitle());
               stmt.setDate(3, Date.valueOf(employee.getHireDate()));
               stmt.setDouble(4, employee.getSalary());
               stmt.setInt(5, employee.getDepartmentId());
               stmt.setInt(6, employee.getId());

               stmt.executeUpdate();
           }
       }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Employee WHERE id = ?";

       if(conn!=null){
           try (PreparedStatement stmt = conn.prepareStatement(sql)) {
               stmt.setInt(1, id);
               stmt.executeUpdate();
           }
       }
    }

    public boolean departmentExists(int departmentId, Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Department WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, departmentId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }
    }

    public boolean employeeExists(int employeeId, Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Employee WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }
    }

    public void updateEmployeeDepartment(int employeeId, int newDepartmentId, Connection conn) throws SQLException {
        String sql = "UPDATE Employee SET departmentId = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newDepartmentId);
            stmt.setInt(2, employeeId);
            stmt.executeUpdate();
        }
    }
}

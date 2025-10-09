package Repository;

import DBConnection.DBConnection;
import Model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    static private final Connection conn = DBConnection.getConnection();

    //Gets all employees.
    public  List<Employee> findAll() {
        try {
            List<Employee> employees = new ArrayList<>();
            if (conn != null) {
                String query = "SELECT * FROM Employee";
                Statement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int emp_id = Integer.parseInt(rs.getString("emp_id"));
                    String name = rs.getString("name");
                    int salary = Integer.parseInt(rs.getString("salary"));
                    int address_id = Integer.parseInt(rs.getString("address_id"));
                    int dept_id = Integer.parseInt(rs.getString("dept_id"));
                    Employee e = new Employee(emp_id, name, salary, address_id, dept_id);
                    employees.add(e);
                }
            }
            return employees;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    //Gets an employee.
    public  Employee findById(int empId) {
        try {
            if (conn != null) {
                String query = "SELECT * FROM Employee WHERE emp_id=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, empId);
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    int emp_id = Integer.parseInt(rs.getString("emp_id"));
                    String name = rs.getString("name");
                    int salary = Integer.parseInt(rs.getString("salary"));
                    int address_id = Integer.parseInt(rs.getString("address_id"));
                    int dept_id = Integer.parseInt(rs.getString("dept_id"));
                    return new Employee(emp_id, name, salary, address_id, dept_id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Inserts a new employee.
    public  void create(Employee employee) {
        if(employee!=null){
            if(conn!=null){
                int id = Math.max(employee.getEmp_id(),0);
                String name = employee.getName().trim();
                int salary = Math.max(employee.getSalary(), 0);
                int addressId = Math.max(employee.getAddress_id(),0);
                int deptId = employee.getDept_id();
                String sql = "INSERT INTO Employee(emp_id,name,salary,address_id,dept_id) VALUES(?,?,?,?,?)";
               try{
                   PreparedStatement ps = conn.prepareStatement(sql);
                   ps.setInt(1,id);
                   ps.setString(2,name);
                   ps.setInt(3,salary);
                   ps.setInt(4,addressId);
                   ps.setInt(5,deptId);
                  int rowsInserted = ps.executeUpdate();
                  if(rowsInserted>0){
                      System.out.println("Employee created");
                  }else{
                      System.out.println("Fail to this create Employee");
                  }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }

            }
        }
    }

    // Updates an employee
   public  void update(Employee employee) {

           if(conn!=null){
              try{
                  int id = Math.max(employee.getEmp_id(),0);
                  String name = employee.getName().trim();
                  int salary = Math.max(employee.getSalary(), 0);
                  int addressId = Math.max(employee.getAddress_id(),0);
                  int deptId = employee.getDept_id();
                  String sql ="UPDATE Employee SET name=?,salary=?,address_id=?,dept_id=? WHERE emp_id=?";
                  PreparedStatement ps = conn.prepareStatement(sql);
                  ps.setString(1,name);
                  ps.setInt(2,salary);
                  ps.setInt(3,addressId);
                  ps.setInt(4,deptId);
                  ps.setInt(5,id);
                  int rowsUpdated = ps.executeUpdate();
                  if(rowsUpdated>0){
                      System.out.println("Updated Successfully");
                  }else{
                      System.out.println("Failed to update");
                  }
              }catch (Exception e){
                  System.out.println(e.getMessage());
              }
           }

    }

    //Deletes an employee
    public  void delete(int empId) {
       try{
           if(conn!=null){
               String sql ="DELETE FROM Employee WHERE emp_id=?";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1,empId);
               int rowsDeleted = ps.executeUpdate();
               if(rowsDeleted>0){
                   System.out.println("Deleted Successfully");
               }else{
                   System.out.println("Failed to delete with id "+empId);
               }
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}

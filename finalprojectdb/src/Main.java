import controller.ClientController;
import controller.DepartmentController;
import controller.EmployeeController;
import controller.ProjectController;
import model.Client;
import model.Department;
import model.Employee;
import utils.DBConnection;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        try {
            //DepartmentController departmentController = new DepartmentController();
            //Department d1 = new Department(6,"Research","San Francisco",75000.0);
           // departmentController.createDepartment(d1);
           // d1.setAnnualBudget(750000.0);
           // departmentController.updateDepartment(d1);
            //departmentController.deleteDepartment(6);
            //departmentController.getDepartmentById(5);
           // departmentController.getAllDepartments();

            //Testing employee
//            EmployeeController ec = new EmployeeController();
//            Employee newEmp = new Employee();
//            newEmp.setId(6);
//            newEmp.setFullName("John Miller");
//            newEmp.setTitle("Software Engineer");
//            newEmp.setHireDate(Date.valueOf(LocalDate.of(2023,5,20)));
//            newEmp.setSalary(85000);
//            newEmp.setDepartmentId(1); // Assuming Department ID 1 exists
//            newEmp.setManagerId(1); // Optional: Manager ID 1
           // ec.createEmployee(newEmp);
            //getting emp by id
            //ec.getEmployeeById(6);
           // newEmp.setHireDate();
            // newEmp.setSalary(90000);
            //ec.updateEmployee(newEmp);
            //ec.deleteEmployee(6);
           // ClientController cc = new ClientController();
            //Client c = new Client();
//            c.setId(6);
//            c.setName("Ferdi");
//            c.setContactEmail("abc@gmail.com");
//            c.setIndustry("Finance");
//            c.setContactPhone("55762576527");
//            c.setContactPersonName("James Carter");
            //cc.createClient(c);
           // c.setContactEmail("zita@gmail.com");
            //cc.updateClient(c);
           // cc.deleteClient(6);
            //cc.getClientById(5);
            //cc.getAllClients();


            ///*

            // for tasks to be tested
            // Initialize controller (handles Service + Repository internally)
            ProjectController projectController = null;
            projectController = new ProjectController();

            //Task 1. Call controller method directly
            projectController.calculateProjectHRCost(1);
            projectController.calculateProjectHRCost(2);

            //Task 2. Test getProjectsByDepartment
            projectController.getProjectsByDepartment(1, "budget");
            projectController.getProjectsByDepartment(1, "endDate");

            // Initialize Client Controller
            ClientController clientController = new ClientController();

            // Task 3. Find clients with projects ending in next 30 days
            clientController.findClientsByUpcomingProjectDeadline(30);
            clientController.findClientsByUpcomingProjectDeadline(60);
            clientController.findClientsByUpcomingProjectDeadline(70);

            // Task 4. Transfer employee ID 1 to department ID 2
            EmployeeController employeeController = new EmployeeController();
            employeeController.transferEmployeeToDepartment(1, 2);

            // */


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close DB connection
            DBConnection.closeConnection();
        }
    }
}


import controller.ClientController;
import controller.DepartmentController;
import controller.EmployeeController;
import controller.ProjectController;
import model.Client;
import model.Department;
import model.Employee;
import model.Project;
import repository.ClientRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;
import service.ClientService;
import service.EmployeeService;
import service.ProjectService;
import utils.DBConnection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp {
    public static void main(String[] args) {
        try {
            // --- Controllers ---
            EmployeeController employeeController = new EmployeeController();
            DepartmentController departmentController = new DepartmentController();
            ProjectController projectController = new ProjectController();
            ClientController clientController = new ClientController();

            // --- DATE FORMAT ---
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // ================== DEPARTMENT CRUD ==================
            Department d1 = new Department(1, "IT", "Building A", 150000);
            departmentController.createDepartment(d1);
            departmentController.getDepartmentById(1);
            departmentController.getAllDepartments();
            d1.setLocation("Building B");
            departmentController.updateDepartment(d1);

            // ================== EMPLOYEE CRUD ==================
//            Employee e1 = new Employee(1, "Alice Johnson", "Developer", new Date(), 6000, 1);
//            Employee e2 = new Employee(2, "Bob Smith", "Manager", new Date(), 8000, 1);
//            employeeController.createEmployee(e1);
//            employeeController.createEmployee(e2);
//            employeeController.getEmployeeById(1);
//            employeeController.getAllEmployees();
//            e1.setTitle("Senior Developer");
//            e1.setSalary(7000);
//            employeeController.updateEmployee(e1);

            // ================== PROJECT CRUD ==================
            Project p1 = new Project(101, "Website Revamp", "Complete overhaul of website",
                    sdf.parse("2025-10-01"), sdf.parse("2025-12-01"), 10000, "Active");
            Project p2 = new Project(102, "Mobile App", "Develop company mobile app",
                    sdf.parse("2025-10-15"), sdf.parse("2026-01-15"), 20000, "Active");
            projectController.createProject(p1);
            projectController.createProject(p2);
            projectController.getProjectById(101);
            projectController.getAllProjects();
            p1.setStatus("In Progress");
            projectController.updateProject(p1);

            // ================== CLIENT CRUD ==================
            Client c1 = new Client(201, "Acme Corp", "Manufacturing", "John Doe", "123-456-7890", "john@acme.com");
            Client c2 = new Client(202, "Globex Inc", "Finance", "Jane Roe", "987-654-3210", "jane@globex.com");
            clientController.createClient(c1);
            clientController.createClient(c2);
            clientController.getClientById(201);
            clientController.getAllClients();
            c1.setContactPhone("555-555-5555");
            clientController.updateClient(c1);

            // ================== BUSINESS LOGIC TASKS ==================

            // 1️⃣ Cost Calculation
            ProjectService projectService = new ProjectService(new ProjectRepository());
            double cost = projectService.calculateProjectHRCost(101);
            System.out.println("Total HR Cost for Project 101: $" + cost);

            // 2️⃣ Department Project Report
            System.out.println("Projects for Department 1 sorted by budget:");
            projectService.getProjectsByDepartment(1, "budget");

            // 3️⃣ High-Value Client Identification
            ClientService clientService = new ClientService(new ClientRepository());
            System.out.println("Clients with projects ending in next 60 days:");
            clientService.findClientsByUpcomingProjectDeadline(60);

            // 4️⃣ Employee Transfer
            EmployeeService employeeService = new EmployeeService(new EmployeeRepository());
            System.out.println("Transferring employee 1 to department 2...");
            employeeService.transferEmployeeToDepartment(1, 2);
            employeeController.getEmployeeById(1);

            // ================== DELETE EXAMPLES ==================
            employeeController.deleteEmployee(2);
            projectController.deleteProject(102);
            clientController.deleteClient(202);
            departmentController.deleteDepartment(1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
    }
}

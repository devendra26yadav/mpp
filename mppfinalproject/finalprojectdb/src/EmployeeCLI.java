
import controller.EmployeeController;
import model.Employee;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeCLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeController controller = new EmployeeController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEMPLOYEE CRUD");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Go Back");
            System.out.print("Choose an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> viewEmployeeById();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> {
                    System.out.println("Exiting From Employee CRUD....Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }


    private static void addEmployee() {
        System.out.println("\n--- Add New Employee ---");
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter hire date (yyyy-mm-dd): ");
        String hireDateStr = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = getDoubleInput();

        System.out.print("Enter department ID: ");
        int departmentId = getIntInput();

        System.out.print("Enter manager ID (or 0 if none): ");
        int managerId = getIntInput();
        Integer mgr = (managerId == 0) ? null : managerId;

        Employee emp = new Employee();
        emp.setFullName(fullName);
        emp.setTitle(title);
        emp.setHireDate(Date.valueOf(hireDateStr));
        emp.setSalary(salary);
        emp.setDepartmentId(departmentId);
        emp.setManagerId(mgr);

        controller.createEmployee(emp);
        System.out.println("Employee added successfully!");
    }

    private static void viewAllEmployees() {
        controller.getAllEmployees();
    }

    private static void viewEmployeeById() {
        System.out.print("\nEnter Employee ID: ");
        int id = getIntInput();
        controller.getEmployeeById(id);
    }

    private static void updateEmployee() {
        System.out.print("\nEnter Employee ID to update: ");
        int id = getIntInput();
        Employee emp = controller.getEmployeeById(id);
        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.println("Current: " + emp);

        System.out.print("Enter new full name (blank = same): ");
        String fullName = scanner.nextLine();
        if (!fullName.isEmpty()) emp.setFullName(fullName);

        System.out.print("Enter new title (blank = same): ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) emp.setTitle(title);

        System.out.print("Enter new salary (or blank = same): ");
        String salaryStr = scanner.nextLine();
        if (!salaryStr.isEmpty()) emp.setSalary(Double.parseDouble(salaryStr));

        System.out.print("Enter new department ID (or 0 = same): ");
        String deptStr = scanner.nextLine();
        if (!deptStr.isEmpty() && !deptStr.equals("0")) emp.setDepartmentId(Integer.parseInt(deptStr));

        System.out.print("Enter new manager ID (or 0 = none): ");
        String mgrStr = scanner.nextLine();
        if (!mgrStr.isEmpty()) emp.setManagerId(mgrStr.equals("0") ? null : Integer.parseInt(mgrStr));

       controller.updateEmployee(emp);
    }

    private static void deleteEmployee() {
        System.out.print("\nEnter Employee ID to delete: ");
        int id = getIntInput();
       controller.deleteEmployee(id);
    }


    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Try again: ");
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid number! Try again: ");
            }
        }
    }
}

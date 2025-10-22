-- Departments
INSERT INTO Department VALUES (1, 'HR', 'New York', 500000);
INSERT INTO Department VALUES (2, 'IT', 'San Francisco', 1200000);
INSERT INTO Department VALUES (3, 'Finance', 'Chicago', 800000);
INSERT INTO Department VALUES (4, 'Marketing', 'Boston', 600000);
INSERT INTO Department VALUES (5, 'Operations', 'Dallas', 700000);

-- Employees
INSERT INTO Employee VALUES (1, 'Alice Johnson', 'Manager', '2020-01-15', 90000, 1);
INSERT INTO Employee VALUES (2, 'Bob Smith', 'Specialist', '2019-03-22', 75000, 2);
INSERT INTO Employee VALUES (3, 'Carol Davis', 'Analyst', '2021-06-12', 65000, 3);
INSERT INTO Employee VALUES (4, 'David Lee', 'Engineer', '2022-02-10', 80000, 2);
INSERT INTO Employee VALUES (5, 'Eve Martinez', 'Coordinator', '2023-09-01', 60000, 4);

-- Projects
INSERT INTO Project VALUES (1, 'AI Platform', 'Developing AI tools', '2023-01-01', '2024-12-31', 1500000, 'Active');
INSERT INTO Project VALUES (2, 'Website Revamp', 'Redesign company site', '2024-03-01', '2024-11-30', 300000, 'Active');
INSERT INTO Project VALUES (3, 'ERP Upgrade', 'Upgrade internal systems', '2024-05-01', '2025-04-30', 500000, 'Completed');
INSERT INTO Project VALUES (4, 'Market Research', 'Study new markets', '2024-09-01', '2025-02-28', 200000, 'Active');
INSERT INTO Project VALUES (5, 'Client Portal', 'New client-facing system', '2024-07-01', '2025-01-31', 400000, 'Active');

-- Clients
INSERT INTO Client VALUES (1, 'TechCorp', 'Technology', 'Jane Doe', '555-1234', 'jane@techcorp.com');
INSERT INTO Client VALUES (2, 'FinServe', 'Finance', 'John Roe', '555-5678', 'john@finserve.com');
INSERT INTO Client VALUES (3, 'MediHealth', 'Healthcare', 'Mary Major', '555-9876', 'mary@medihealth.com');
INSERT INTO Client VALUES (4, 'GreenEnergy', 'Energy', 'Alan Solar', '555-3456', 'alan@greenenergy.com');
INSERT INTO Client VALUES (5, 'EduNext', 'Education', 'Sara Learn', '555-7890', 'sara@edunext.com');

-- DepartmentProject
INSERT INTO DepartmentProject VALUES (1, 1); -- HR involved in AI Platform
INSERT INTO DepartmentProject VALUES (2, 1); -- IT involved in AI Platform
INSERT INTO DepartmentProject VALUES (2, 2); -- IT working on Website Revamp
INSERT INTO DepartmentProject VALUES (3, 3); -- Finance handling ERP Upgrade
INSERT INTO DepartmentProject VALUES (4, 4); -- Marketing on Market Research
INSERT INTO DepartmentProject VALUES (5, 5); -- Operations on Client Portal
INSERT INTO DepartmentProject VALUES (1, 5); -- HR also involved in Client Portal

-- EmployeeProject
INSERT INTO EmployeeProject VALUES (1, 1, 50.0);
INSERT INTO EmployeeProject VALUES (2, 1, 70.0);
INSERT INTO EmployeeProject VALUES (3, 2, 60.0);
INSERT INTO EmployeeProject VALUES (4, 3, 80.0);
INSERT INTO EmployeeProject VALUES (5, 4, 40.0);

-- ProjectClient
INSERT INTO ProjectClient VALUES (1, 1);
INSERT INTO ProjectClient VALUES (1, 2);
INSERT INTO ProjectClient VALUES (2, 3);
INSERT INTO ProjectClient VALUES (3, 1);
INSERT INTO ProjectClient VALUES (5, 5);

-- ================== SAMPLE DATA ==================

-- Departments
INSERT INTO Department (name, location, annualBudget) VALUES
('Engineering', 'New York', 1200000),
('Human Resources', 'Chicago', 400000),
('Finance', 'Boston', 600000),
('Marketing', 'Los Angeles', 500000),
('IT Support', 'Austin', 300000);

-- Employees
INSERT INTO Employee (fullName, title, hireDate, salary, departmentId, managerId) VALUES
('Alice Johnson', 'Engineering Manager', '2018-03-15', 95000, 1, NULL),
('Bob Smith', 'Software Engineer', '2020-07-01', 80000, 1, 1),
('Carol White', 'HR Specialist', '2019-09-10', 60000, 2, NULL),
('David Lee', 'Financial Analyst', '2021-02-05', 70000, 3, NULL),
('Eva Green', 'IT Support Technician', '2022-05-12', 55000, 5, NULL);

-- Projects
INSERT INTO Project (name, description, startDate, endDate, budget, status) VALUES
('Project Apollo', 'AI automation for customer service', '2024-01-10', '2024-12-31', 300000, 'Active'),
('Project Orion', 'Mobile app for HR onboarding', '2024-03-01', '2025-02-28', 150000, 'Active'),
('Project Titan', 'Financial data analysis system', '2023-09-01', '2024-03-30', 200000, 'Completed'),
('Project Zenith', 'Marketing analytics dashboard', '2024-06-15', '2025-01-15', 180000, 'Active'),
('Project Helios', 'Internal IT automation tools', '2024-09-01', '2025-04-01', 100000, 'Planned'),
(101, 'Quick Project', 'Ends in 2 weeks', '2025-10-15', '2025-11-05', 5000, 'Active'),
(102, 'Medium Project', 'Ends in 45 days', '2025-10-01', '2025-12-06', 10000, 'Active'),
(103, 'Long Project', 'Ends in 65 days', '2025-10-01', '2025-12-26', 20000, 'Active');

-- Clients
INSERT INTO Client (name, industry, contactPersonName, contactPhone, contactEmail) VALUES
('TechNova Solutions', 'Technology', 'James Carter', '555-1234', 'james@technova.com'),
('FinEdge Corp', 'Finance', 'Laura Chen', '555-5678', 'laura@finedge.com'),
('BrightWorks Ltd', 'Marketing', 'Oliver Scott', '555-8765', 'oliver@brightworks.com'),
('InnoHealth Partners', 'Healthcare', 'Sophia Patel', '555-4321', 'sophia@innohealth.com'),
('OmniCore Industries', 'Manufacturing', 'Liam Davis', '555-6789', 'liam@omnicore.com'),
(201, 'Acme Corp', 'Manufacturing', 'John Doe', '123-456-7890', 'john@acme.com'),
(202, 'Beta LLC', 'IT Services', 'Jane Smith', '234-567-8901', 'jane@beta.com'),
(203, 'Gamma Inc', 'Healthcare', 'Mike Johnson', '345-678-9012', 'mike@gamma.com');

-- DepartmentProject
INSERT INTO DepartmentProject (departmentId, projectId) VALUES
(1, 1),
(1, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 101),
(2, 102),
(3, 103);

-- EmployeeProject
INSERT INTO EmployeeProject (employeeId, projectId, allocationPercentage, role) VALUES
(1, 1, 40, 'Manager'),
(2, 1, 60, 'Developer'),
(2, 2, 50, 'Lead Developer'),
(4, 3, 80, 'Analyst'),
(5, 5, 100, 'Support Engineer'),
(1, 101, 50, 'Manager'),
(2, 102, 50, 'Developer'),
(3, 103, 70, 'Analyst');

-- ProjectClient
INSERT INTO ProjectClient (projectId, clientId) VALUES
(1, 1),
(1, 4),
(2, 3),
(3, 2),
(4, 3),
(101, 201),
(102, 202),
(103, 203);
CREATE TABLE Department (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    annualBudget DOUBLE
);

CREATE TABLE Employee (
    id INT PRIMARY KEY,
    fullName VARCHAR(100),
    title VARCHAR(50),
    hireDate DATE,
    salary DOUBLE,
    departmentId INT,
    FOREIGN KEY (departmentId) REFERENCES Department(id)
);

CREATE TABLE Project (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    startDate DATE,
    endDate DATE,
    budget DOUBLE,
    status VARCHAR(20)
);

CREATE TABLE Client (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    industry VARCHAR(100),
    contactPersonName VARCHAR(100),
    contactPhone VARCHAR(20),
    contactEmail VARCHAR(100)
);

CREATE TABLE DepartmentProject (
    departmentId INT,
    projectId INT,
    PRIMARY KEY (departmentId, projectId),
    FOREIGN KEY (departmentId) REFERENCES Department(id),
    FOREIGN KEY (projectId) REFERENCES Project(id)
);

CREATE TABLE EmployeeProject (
    employeeId INT,
    projectId INT,
    allocationPercentage DOUBLE,
    PRIMARY KEY (employeeId, projectId),
    FOREIGN KEY (employeeId) REFERENCES Employee(id),
    FOREIGN KEY (projectId) REFERENCES Project(id)
);

CREATE TABLE ProjectClient (
    projectId INT,
    clientId INT,
    PRIMARY KEY (projectId, clientId),
    FOREIGN KEY (projectId) REFERENCES Project(id),
    FOREIGN KEY (clientId) REFERENCES Client(id)
);

CREATE TABLE Department (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    annualBudget DOUBLE DEFAULT 0
);

CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullName VARCHAR(100) NOT NULL,
    title VARCHAR(50),
    hireDate DATE NOT NULL,
    salary DOUBLE CHECK (salary >= 0),
    departmentId INT NOT NULL,
    managerId INT NULL,
    FOREIGN KEY (departmentId) REFERENCES Department(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    FOREIGN KEY (managerId) REFERENCES Employee(id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);


CREATE TABLE Project (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    startDate DATE,
    endDate DATE,
    budget DOUBLE CHECK (budget >= 0),
    status VARCHAR(20) DEFAULT 'Planned'
    -- Possible values: 'Planned', 'Active', 'Completed', 'On Hold', 'Cancelled'
);


CREATE TABLE Client (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    industry VARCHAR(100),
    contactPersonName VARCHAR(100),
    contactPhone VARCHAR(20),
    contactEmail VARCHAR(100),
    UNIQUE (contactEmail)
);

-- =========================================
-- TABLE: DepartmentProject (N:M)
-- =========================================
CREATE TABLE DepartmentProject (
    departmentId INT,
    projectId INT,
    PRIMARY KEY (departmentId, projectId),
    FOREIGN KEY (departmentId) REFERENCES Department(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (projectId) REFERENCES Project(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- TABLE: EmployeeProject (N:M)
-- =========================================
CREATE TABLE EmployeeProject (
    employeeId INT,
    projectId INT,
    allocationPercentage DOUBLE CHECK (allocationPercentage BETWEEN 0 AND 100),
    role VARCHAR(50),
    PRIMARY KEY (employeeId, projectId),
    FOREIGN KEY (employeeId) REFERENCES Employee(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (projectId) REFERENCES Project(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- TABLE: ProjectClient (N:M)
-- =========================================
CREATE TABLE ProjectClient (
    projectId INT,
    clientId INT,
    PRIMARY KEY (projectId, clientId),
    FOREIGN KEY (projectId) REFERENCES Project(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (clientId) REFERENCES Client(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

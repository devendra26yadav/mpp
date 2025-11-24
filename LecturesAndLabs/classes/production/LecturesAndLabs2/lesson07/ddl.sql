CREATE DATABASE company_db;

use company_db;

CREATE TABLE Employees (
	employee_id INT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	email VARCHAR(100) UNIQUE,
	salary DECIMAL(10,2) CHECK (salary > 0),
	department_id INT,
	hire_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE Employees ADD phone_number VARCHAR(15);

ALTER TABLE Employees MODIFY salary DECIMAL(12,2) NOT NULL;

ALTER TABLE Employees RENAME COLUMN hire_date TO joining_date;

ALTER TABLE Employees DROP COLUMN phone_number;

-- DROP TABLE Employees;

RENAME TABLE Employees TO Staff;





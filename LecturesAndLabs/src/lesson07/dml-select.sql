use company_db;

SELECT staffNo, fName, lName, position, sex, DOB, salary, branchNo FROM Staff;

SELECT  * FROM Staff;

SELECT staffNo, fName, lName, salary FROM Staff;

SELECT propertyNo FROM Viewing;

SELECT distinct propertyNo FROM Viewing;

SELECT staffNo, fName, lName, salary/12 FROM Staff;

SELECT staffNo, fName, lName, salary/12 as sal FROM Staff;

SELECT staffNo, fName, lName, position, salary FROM Staff WHERE salary > 10000;

-- List addresses of all branch offices in London or Glasgow.
SELECT * FROM Branch WHERE city = 'London' OR city = 'Glasgow';

-- List all managers and supervisors.
SELECT staffNo, fName, lName, position FROM Staff WHERE position = 'Manager' OR position = 'Supervisor';
SELECT staffNo, fName, lName, position FROM Staff WHERE position IN ('Manager', 'Supervisor');


SELECT ownerNo, fName, lName, address, telNo FROM PrivateOwner WHERE address LIKE '%Glasgow%';

SELECT clientNo, viewDate FROM Viewing WHERE propertyNo = 'PG4' AND comment IS NULL;

SELECT staffNo, fName, lName, salary FROM Staff ORDER BY salary DESC;

SELECT propertyNo, type, rooms, rent FROM PropertyForRent ORDER BY type, rent DESC;

SELECT COUNT(*) AS myCount FROM PropertyForRent WHERE rent > 350;

SELECT COUNT(DISTINCT propertyNo) AS myCount FROM Viewing WHERE viewDate BETWEEN '2013-05-01' AND '2013-05-31';
 
SELECT COUNT(staffNo) AS myCount, SUM(salary) AS mySum FROM Staff WHERE position = 'Manager';

SELECT MIN(salary) AS myMin,  MAX(salary) AS myMax, AVG(salary) AS myAvg FROM Staff;

SELECT branchNo, COUNT(*) AS staffCount, SUM(salary) AS sumOfSalary FROM Staff GROUP BY branchNo ORDER BY branchNo;

SELECT branchNo, COUNT(staffNo) AS myCount, SUM(salary) AS mySum FROM Staff GROUP BY branchNo HAVING COUNT(staffNo) > 1 ORDER BY branchNo;

SELECT staffNo, fName, lName, position FROM Staff
WHERE branchNo =
		(SELECT branchNo
		FROM Branch
		WHERE street = '163 Main St');
        
SELECT staffNo, fName, lName, position,
   (salary - (SELECT AVG(salary) FROM Staff)) As SalDiff
FROM Staff
WHERE salary > (SELECT AVG(salary) FROM Staff);

-- Join starts here

-- List names of all clients who have viewed a property along with any comment supplied.
SELECT c.clientNo, fName, lName, propertyNo, comment
FROM Client c, Viewing v
WHERE c.clientNo = v.clientNo;

SELECT c.clientNo, fName, lName, propertyNo, comment
FROM Client c INNER JOIN Viewing v ON c.clientNo = v.clientNo;

SELECT s.branchNo, s.staffNo, fName, lName, propertyNo
FROM Staff s, PropertyForRent p
WHERE s.staffNo = p.staffNo
ORDER BY s.branchNo, s.staffNo, propertyNo;


SELECT b.*, p.*
FROM Branch1 b, PropertyForRent1 p WHERE b.bCity = p.pCity;

SELECT b.*, p.* FROM Branch1 b LEFT JOIN PropertyForRent1 p ON  b.bCity = p.pCity;

SELECT b.*, p.*
FROM Branch1 b RIGHT JOIN
PropertyForRent1 p ON 
b.bCity = p.pCity;

-- SELECT b.*, p.* FROM Branch1 b FULL JOIN PropertyForRent1 p ON b.bCity = p.pCity;

SELECT b.*, p.*
FROM Branch1 b
LEFT JOIN PropertyForRent1 p ON b.bCity = p.pCity

UNION

SELECT b.*, p.*
FROM Branch1 b
RIGHT JOIN PropertyForRent1 p ON b.bCity = p.pCity;
















                      




ALTER TABLE employee
DROP CONSTRAINT fk_employee_superssn_ssn;

ALTER TABLE employee
DROP CONSTRAINT fk_employee_department;

ALTER TABLE department
DROP CONSTRAINT fk_department_employee;

ALTER TABLE project
DROP CONSTRAINT fk_project_department;

ALTER TABLE works_on
DROP CONSTRAINT fk_works_on_employee;

ALTER TABLE works_on
DROP CONSTRAINT fk_works_on_project;

ALTER TABLE dependent
DROP CONSTRAINT fk_dependent_employee;

DROP TABLE employee;
DROP TABLE project;

DROP TABLE department;

DROP TABLE dept_location;
DROP TABLE works_on;
DROP TABLE dependent;

DROP TYPE Address;

-- Ex1 schema;
CREATE TABLE employee(
  FName VARCHAR(15),
  Minit CHAR(2),
  LName CHAR(15),
  SSN CHAR(9),
  BDate DATE,
  Address VARCHAR(50),
  Sex CHAR(1),
  Salary NUMBER(7),
  SuperSSN CHAR(9),
  DepNo NUMBER(5)
);

CREATE TABLE project(
  PName VARCHAR(15),
  PNumber NUMBER(5),
  PLocation VARCHAR(15),
  DepNo NUMBER(5)
);


CREATE TABLE department(
  DName VARCHAR(15),
  DepNo NUMBER(5),
  MgrSSN CHAR(9),
  MgrStartDate DATE
);

-- Insert data and run the queries here;

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Doug', 'E', 'Gilbert', '554433221', TO_DATE('09-JUN-60', 'DD-MON-RR'), '11 S 59 E, Salt Lake City, UT', 'M', 80000, NULL, 3);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Joyce', NULL, 'PAN', '543216789', TO_DATE('07-FEB-78', 'DD-MON-RR'), '35 S 18 E, Salt Lake City, UT', 'F', 70000, NULL, 2);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Frankin', 'T', 'Wong', '333445555', TO_DATE('08-DEC-45', 'DD-MON-RR'), '638 Voss, Houston, TX', 'M', 40000, '554433221', 5);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Jennifer', 'S', 'Wallace', '987654321', TO_DATE('20-JUN-31', 'DD-MON-RR'), '291 Berry, Bellaire, TX', 'F', 43000, '554433221', 4);
INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('John', 'B', 'Smith', '123456789', TO_DATE('09-JAN-55', 'DD-MON-RR'), '731 Fondren, Houston, TX', 'M', 30000, '333445555', 5);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Ramesh', 'K', 'Narayan', '666884444', TO_DATE('15-SEP-52', 'DD-MON-RR'), '975 Fire Oak, Humble, TX', 'M', 38000, '333445555', 5);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Joyce', 'A', 'English', '453453453', TO_DATE('31-JUL-62', 'DD-MON-RR'), '5631 Rice, Houston, TX', 'F', 25000, '333445555', 5);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('James', 'E', 'Borg', '888665555', TO_DATE('10-NOV-27', 'DD-MON-RR'), '450 Stone, Houston, TX', 'M', 55000, '543216789', 1);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Alicia', 'J', 'Zelaya', '999887777', TO_DATE('19-JUL-58', 'DD-MON-RR'), '3321 Castle, Spring, TX', 'F', 25000, '987654321', 4);

INSERT INTO employee (FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo)
VALUES ('Alimad', 'V', 'Jabbar', '987987987', TO_DATE('29-MAR-59', 'DD-MON-RR'), '980 Dallas, Houston, TX', 'M', 25000, '987654321', 4);





INSERT INTO department (DName, DepNo, MgrSSN, MgrStartDate)
VALUES ('Manufacture', 1, '888665555', TO_DATE('19-JUN-71', 'DD-Mon-RR'));

INSERT INTO department (DName, DepNo, MgrSSN, MgrStartDate)
VALUES ('Administration', 2, '543216789', TO_DATE('04-JAN-99', 'DD-Mon-RR'));

INSERT INTO department (DName, DepNo, MgrSSN, MgrStartDate)
VALUES ('Headquarter', 3, '554433221', TO_DATE('22-SEP-55', 'DD-Mon-RR'));

INSERT INTO department (DName, DepNo, MgrSSN, MgrStartDate)
VALUES ('Finance', 4, '987654321', TO_DATE('01-JAN-85', 'DD-Mon-RR'));

INSERT INTO department (DName, DepNo, MgrSSN, MgrStartDate)
VALUES ('Research', 5, '333445555', TO_DATE('22-MAY-78', 'DD-Mon-RR'));






INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectA', 3388, 'Houston', 1);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectB', 1945, 'Salt Lake City', 3);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectC', 6688, 'Houston', 5);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectD', 2423, 'Bellaire', 4);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectE', 7745, 'Sugarland', 5);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectF', 1566, 'Salt Lake City', 3);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectG', 1234, 'New York', 2);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectH', 3467, 'Stafford', 4);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectI', 4345, 'Chicago', 1);

INSERT INTO project (PName, PNumber, PLocation, DepNo)
VALUES ('ProjectJ', 2212, 'San Francisco', 2);

-- Running queries

SELECT * FROM employee;

SELECT FName, Minit, LName, SSN, SuperSSN FROM employee;

SELECT Fname, Minit, Lname FROM employee WHERE Bdate = TO_DATE('29-MAR-1959', 'DD-Mon-YY');

SELECT DISTINCT Salary FROM employee;

SELECT MgrSSN, MgrStartDate
FROM department
WHERE DName = 'Finance';

UPDATE employee
SET DepNo = 5
WHERE FName = 'Joyce';

ALTER TABLE department
ADD DepartmentPhoneNum NUMBER(10);

UPDATE department
SET DepartmentPhoneNum = 1504015040;

ALTER TABLE department
MODIFY DepartmentPhoneNum NUMBER(10) NOT NULL;

ALTER TABLE department
MODIFY DepartmentPhoneNum NUMBER(12);

ALTER TABLE department
RENAME COLUMN DepartmentPhoneNum TO PhNo;

RENAME department TO DEPT;

RENAME DEPT TO department;

-- Ex2 schema alterations

ALTER TABLE employee
MODIFY FName VARCHAR2(15) NOT NULL;

ALTER TABLE employee
MODIFY LName VARCHAR2(15) NOT NULL;

ALTER TABLE employee
MODIFY SSN CHAR(9) PRIMARY KEY;

ALTER TABLE employee
MODIFY Salary NUMBER(7) DEFAULT 800;

ALTER TABLE employee
ADD CHECK(sex IN ('M', 'F', 'm', 'f'));

ALTER TABLE department
MODIFY DepNo NUMBER(5) PRIMARY KEY;

ALTER TABLE department
MODIFY DName VARCHAR2(15) NOT NULL;

ALTER TABLE project
MODIFY PName VARCHAR2(15) NOT NULL;

ALTER TABLE project
MODIFY PNumber NUMBER(5) PRIMARY KEY;

-- Foreign Keys

ALTER TABLE employee
ADD CONSTRAINT fk_employee_superssn_ssn
FOREIGN KEY (SuperSSN) REFERENCES employee(SSN)
ON DELETE SET NULL;

ALTER TABLE employee
ADD CONSTRAINT fk_employee_department
FOREIGN KEY (DepNo) REFERENCES department(DepNo)
ON DELETE CASCADE;

ALTER TABLE department
ADD CONSTRAINT fk_department_employee
FOREIGN KEY (MgrSSN) REFERENCES employee(SSN)
ON DELETE SET NULL;

ALTER TABLE project
ADD CONSTRAINT fk_project_department
FOREIGN KEY (DepNo) REFERENCES department(DepNo)
ON DELETE SET NULL;

-- New tables

CREATE TABLE dept_location (
    DepNo NUMBER(5),
    DLocation VARCHAR(15),
    CONSTRAINT fk_dept_location_department
    FOREIGN KEY (DepNo) REFERENCES department(DepNo)
    ON DELETE CASCADE
);

CREATE TABLE works_on (
  ESSN CHAR(9),
  Pno NUMBER(5),
  Hours NUMBER(6,2),
  CONSTRAINT fk_works_on_employee
    FOREIGN KEY (ESSN) REFERENCES employee(SSN)
    ON DELETE CASCADE,
  CONSTRAINT fk_works_on_project
    FOREIGN KEY (Pno) REFERENCES project(PNumber)
    ON DELETE CASCADE
);


CREATE TABLE dependent(
  ESSN CHAR(9),
  Dependent_name VARCHAR(15),
  Sex CHAR(1),
  Bdate DATE,
  Relationship VARCHAR(8),
  CONSTRAINT fk_dependent_employee
    FOREIGN KEY (ESSN) REFERENCES employee(SSN)
    ON DELETE CASCADE
);

INSERT INTO dept_location (DepNo, DLocation) VALUES (1, 'Houston');
INSERT INTO dept_location (DepNo, DLocation) VALUES (1, 'Chicago');
INSERT INTO dept_location (DepNo, DLocation) VALUES (2, 'New York');
INSERT INTO dept_location (DepNo, DLocation) VALUES (2, 'San Francisco');
INSERT INTO dept_location (DepNo, DLocation) VALUES (3, 'Salt Lake City');
INSERT INTO dept_location (DepNo, DLocation) VALUES (4, 'Stafford');
INSERT INTO dept_location (DepNo, DLocation) VALUES (4, 'Bellaire');
INSERT INTO dept_location (DepNo, DLocation) VALUES (5, 'Sugarland');
INSERT INTO dept_location (DepNo, DLocation) VALUES (5, 'Houston');




INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('123456789', 3388, 32.5);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('123456789', 1945, 7.5);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('666884444', 3388, 40);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('453453453', 7745, 20);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('453453453', 2212, 20);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('333445555', 7745, 10);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('333445555', 6688, 10);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('333445555', 4345, 35);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('333445555', 2212, 28.5);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('999887777', 1566, 11.5);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('999887777', 1234, 13);
INSERT INTO works_on (ESSN, Pno, Hours) VALUES ('543216789', 2212, 17);




INSERT INTO dependent (ESSN, Dependent_name, Sex, Bdate, Relationship) VALUES ('333445555', 'Alice', 'F', TO_DATE('05-Apr-76', 'DD-Mon-YY'), 'Daughter');
INSERT INTO dependent (ESSN, Dependent_name, Sex, Bdate, Relationship) VALUES ('333445555', 'Theodore', 'M', TO_DATE('25-Oct-73', 'DD-Mon-YY'), 'Son');
INSERT INTO dependent (ESSN, Dependent_name, Sex, Bdate, Relationship) VALUES ('333445555', 'Joy', 'F', TO_DATE('03-May-48', 'DD-Mon-YY'), 'Spouse');
INSERT INTO dependent (ESSN, Dependent_name, Sex, Bdate, Relationship) VALUES ('987654321', 'Abner', 'M', TO_DATE('29-Feb-32', 'DD-Mon-YY'), 'Spouse');
INSERT INTO dependent (ESSN, Dependent_name, Sex, Bdate, Relationship) VALUES ('123456789', 'Alice', 'F', TO_DATE('31-Dec-78', 'DD-Mon-YY'), 'Daughter');
INSERT INTO dependent (ESSN, Dependent_name, Sex, Bdate, Relationship) VALUES ('123456789', 'Elizabeth', 'F', TO_DATE('05-May-57', 'DD-Mon-YY'), 'Spouse');

-- Ex2 queries

INSERT INTO employee (
  FName, Minit, LName, SSN, BDate, Address, Sex, Salary, SuperSSN, DepNo
) VALUES (
  'Robert', 'F', 'Scott', '943775543', TO_DATE('21-JUN-42', 'DD-MON-YY'),
  '2365 Newcastle Rd, Bellaire, TX', 'M', 58000, '888665555', 1
);


-- NOTE: This violates foreign key
INSERT INTO works_on (
  ESSN, Pno, Hours
) VALUES (
  '677678989', NULL, 40.0
);

INSERT INTO dependent (
  ESSN, Dependent_name, Sex, Bdate, Relationship
) VALUES (
  '453453453', 'John', 'M', TO_DATE('12-DEC-60', 'DD-MON-YY'), 'SPOUSE'
);

DELETE FROM works_on
WHERE ESSN = '333445555';

UPDATE department
SET MgrSSN = '123456789',
    MgrStartDate = TO_DATE('01-OCT-88', 'DD-MON-YY')
WHERE DepNo = 5;


ALTER TABLE employee
DROP CONSTRAINT fk_employee_superssn_ssn;

ALTER TABLE project
ADD CONSTRAINT uq_project_name UNIQUE (PName);

ALTER TABLE employee
MODIFY Sex CHAR(1) NOT NULL;

CREATE TYPE Address AS OBJECT (
    door_no VARCHAR2(10),
    street VARCHAR2(100),
    city VARCHAR2(50),
    state VARCHAR2(50),
    continent VARCHAR2(20)
);
/

ALTER TABLE employee ADD TempSalary FLOAT(8);
UPDATE employee SET TempSalary = Salary;
ALTER TABLE employee DROP COLUMN Salary;
ALTER TABLE employee RENAME COLUMN TempSalary TO Salary;


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


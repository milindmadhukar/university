DROP TABLE department;
DROP TABLE procedure;
DROP TABLE works_with;
DROP TABLE appointment;
DROP TABLE patient;
DROP TABLE nurse;
DROP TABLE physician;


CREATE TABLE physician (
employeeid INT PRIMARY KEY,
name VARCHAR2(255),
position VARCHAR2(255),
ssn INT
);

CREATE TABLE department (
departmentid INT PRIMARY KEY,
name VARCHAR2(255),
head INT REFERENCES physician(employeeid)
);

CREATE TABLE works_with (
physician INT REFERENCES physician(employeeid),
department INT REFERENCES physician(employeeid),
primaryaffiliation CHAR,
CHECK (primaryaffiliation IN ('Y', 'N'))
);

CREATE TABLE procedure (
code INT UNIQUE,
name VARCHAR(255),
cost INT
);

CREATE TABLE patient(
ssn INT PRIMARY KEY,
name VARCHAR(255),
address VARCHAR(255),
phone INT,
insuranceid INT,
pcp INT REFERENCES physician(employeeid)
);

CREATE TABLE nurse (
employeeid INT PRIMARY KEY,
name VARCHAR2(255),
position VARCHAR2(255),
ssn INT,
registered CHAR,
CHECK (registered IN ('Y', 'N'))
);

CREATE TABLE appointment (
appointmentid INT PRIMARY KEY,
patient INT REFERENCES patient(ssn),
prepnurse INT REFERENCES nurse(employeeid),
physician INT REFERENCES physician(employeeid),
date_of_appointment DATE,
start_time DATE,
end_time DATE
);

-- Insert into physician (including those without affiliations)
INSERT INTO physician (employeeid, name, position, ssn) VALUES (1, 'Milind Madhukar', 'Cardiologist', 1111);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (2, 'Martin Garrix', 'Neurologist', 2222);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (3, 'Ishani Bildikar', 'Pediatrician', 3333);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (4, 'Ishaan Jain', 'Orthopedic', 4444);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (5, 'Vaibhav Pandey', 'General Practitioner', 5555);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (6, 'Viraj Ajmera', 'Surgeon', 6666);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (7, 'Neel Kasar', 'Gastroenterologist', 7777);
-- Physicians without any affiliations
INSERT INTO physician (employeeid, name, position, ssn) VALUES (9, 'Om Gupta', 'Dermatologist', 9999);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (10, 'Aditya Singh', 'Endocrinologist', 1010);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (11, 'Param Chhabra', 'Oncologist', 1110);
INSERT INTO physician (employeeid, name, position, ssn) VALUES (12, 'Charan', 'Oncologist', 1069);


-- Insert into department
INSERT INTO department (departmentid, name, head) VALUES (1, 'Cardiology', 1);
INSERT INTO department (departmentid, name, head) VALUES (2, 'Neurology', 2);
INSERT INTO department (departmentid, name, head) VALUES (3, 'Pediatrics', 3);
INSERT INTO department (departmentid, name, head) VALUES (4, 'Orthopedics', 4);
INSERT INTO department (departmentid, name, head) VALUES (5, 'Gastroenterology', 7);

-- Insert into works_with
INSERT INTO works_with (physician, department, primaryaffiliation) VALUES (1, 1, 'Y');
INSERT INTO works_with (physician, department, primaryaffiliation) VALUES (2, 2, 'Y');
INSERT INTO works_with (physician, department, primaryaffiliation) VALUES (3, 3, 'Y');
INSERT INTO works_with (physician, department, primaryaffiliation) VALUES (4, 4, 'Y');
INSERT INTO works_with (physician, department, primaryaffiliation) VALUES (7, 5, 'Y');

-- Insert into procedure
INSERT INTO procedure (code, name, cost) VALUES (1001, 'Physiotherapy', 200);
INSERT INTO procedure (code, name, cost) VALUES (1002, 'Gastric problem', 150);
INSERT INTO procedure (code, name, cost) VALUES (1003, 'Knee Replacement', 5000);
INSERT INTO procedure (code, name, cost) VALUES (1004, 'Heart Bypass Surgery', 10000);
INSERT INTO procedure (code, name, cost) VALUES (1005, 'Appendectomy', 3000);

-- Insert into patient
INSERT INTO patient (ssn, name, address, phone, insuranceid, pcp) VALUES (123456789, 'Brian Thomas', '123 Elm St', 9876543210, 11111, 1);
INSERT INTO patient (ssn, name, address, phone, insuranceid, pcp) VALUES (987654321, 'Neel Kasar', '456 Oak St', 8765432109, 22222, 2);
INSERT INTO patient (ssn, name, address, phone, insuranceid, pcp) VALUES (112233445, 'Samantha Cruz', '789 Pine St', 7654321098, 33333, 3);
INSERT INTO patient (ssn, name, address, phone, insuranceid, pcp) VALUES (998877665, 'Christopher Nolan', '321 Maple St', 6543210987, 44444, 4);
INSERT INTO patient (ssn, name, address, phone, insuranceid, pcp) VALUES (556677889, 'Charlie Brown', '654 Birch St', 5432109876, 55555, 5);

-- Insert into nurse
INSERT INTO nurse (employeeid, name, position, ssn, registered) VALUES (1, 'Anya Sirhoi', 'Head Nurse', 7777, 'Y');
INSERT INTO nurse (employeeid, name, position, ssn, registered) VALUES (2, 'Dhairya Sharma', 'Staff Nurse', 8888, 'Y');
INSERT INTO nurse (employeeid, name, position, ssn, registered) VALUES (3, 'Nachikat Pensalwar', 'Staff Nurse', 9999, 'Y');
INSERT INTO nurse (employeeid, name, position, ssn, registered) VALUES (4, 'Rishbh Arora', 'Assistant Nurse', 6666, 'N');
INSERT INTO nurse (employeeid, name, position, ssn, registered) VALUES (5, 'Shivesh', 'Staff Nurse', 5555, 'Y');
INSERT INTO nurse (employeeid, name, position, ssn, registered) VALUES (6, 'Chetan', 'Staff Nurse', 4444, 'Y');
INSERT INTO nurse (employeeid, name, position, ssn, registered) VALUES (7, 'Chirag', 'Staff Nurse', 3333, 'Y');

-- Insert into appointment
INSERT INTO appointment (appointmentid, patient, prepnurse, physician, date_of_appointment, start_time, end_time) 
VALUES (1, 123456789, 1, 1, TO_DATE('2024-08-20', 'YYYY-MM-DD'), TO_DATE('2024-08-20 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-08-20 14:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO appointment (appointmentid, patient, prepnurse, physician, date_of_appointment, start_time, end_time) 
VALUES (2, 987654321, 2, 2, TO_DATE('2024-08-21', 'YYYY-MM-DD'), TO_DATE('2024-08-21 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-08-21 14:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO appointment (appointmentid, patient, prepnurse, physician, date_of_appointment, start_time, end_time) 
VALUES (3, 112233445, 3, 3, TO_DATE('2024-08-22', 'YYYY-MM-DD'), TO_DATE('2024-08-22 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-08-22 12:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO appointment (appointmentid, patient, prepnurse, physician, date_of_appointment, start_time, end_time) 
VALUES (4, 998877665, 4, 4, TO_DATE('2024-08-23', 'YYYY-MM-DD'), TO_DATE('2024-08-23 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-08-23 15:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO appointment (appointmentid, patient, prepnurse, physician, date_of_appointment, start_time, end_time) 
VALUES (5, 556677889, 5, 5, TO_DATE('2024-08-24', 'YYYY-MM-DD'), TO_DATE('2024-08-24 16:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-08-24 16:30:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Queries

SELECT * FROM physician;

SELECT name, cost 
FROM procedure 
WHERE name IN ('Physiotherapy', 'Gastric problem');

SELECT p.employeeid, p.name, p.position, p.ssn, w.department AS affiliation
FROM physician p
LEFT JOIN works_with w ON p.employeeid = w.physician
WHERE w.department IS NULL;

SELECT employeeid AS empid, name, ssn
FROM physician
WHERE LOWER(name) LIKE 'c%';

SELECT employeeid AS empid, name, ssn
FROM nurse
WHERE LOWER(name) LIKE 'c%';

SELECT p.*
FROM patient p
JOIN appointment a ON p.ssn = a.patient
WHERE a.start_time > TO_DATE(TO_CHAR(a.date_of_appointment, 'YYYY-MM-DD') || ' 12:30:00', 'YYYY-MM-DD HH24:MI:SS');

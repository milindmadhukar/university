-- @/home/dbms/query.sql
declare
   cursor emp_dept_cursor is
   select e.fname,
          e.Minit,
          e.lname,
          e.ssn,
          e.Bdate,
          e.address,
          e.sex,
          e.salary,
          d.Dname,
          d.DepNo
     from employee e
     join department d
   on e.DepNo = d.DepNo;


   emp_dept_record emp_dept_cursor%rowtype;
begin
   open emp_dept_cursor;
   loop
      fetch emp_dept_cursor into emp_dept_record;
      exit when emp_dept_cursor%notfound;
      dbms_output.put_line('Employee Name: '
                           || emp_dept_record.fname
                           || ' '
                           || emp_dept_record.Minit
                           || ' '
                           || emp_dept_record.lname);
      dbms_output.put_line('SSN Number: ' || emp_dept_record.ssn);
      dbms_output.put_line('Bdate: ' || emp_dept_record.Bdate);
      dbms_output.put_line('Address: ' || emp_dept_record.address);
      dbms_output.put_line('Sex: ' || emp_dept_record.sex);
      dbms_output.put_line('Salary: ' || emp_dept_record.salary);
      dbms_output.put_line('Department Name: ' || emp_dept_record.Dname);
      dbms_output.put_line('Department Number: ' || emp_dept_record.DepNo);
      dbms_output.put_line('--------------------------------------');
   end loop;


   close emp_dept_cursor;
end;
/


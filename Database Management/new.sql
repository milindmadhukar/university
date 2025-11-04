declare
   empno      employee.ssn%type;
   emp_salary employee.salary%type;
begin
   empno := '&Enter_EmpNo';
   select salary
     into emp_salary
     from employee
    where ssn = empno;


   dbms_output.put_line('Salary of the employee with EmpNo '
                        || empno
                        || ' is: '
                        || to_char(emp_salary));


exception
   when no_data_found then
      dbms_output.put_line('No employee found with EmpNo ' || empno);
   when others then
      dbms_output.put_line('An error occurred: ' || sqlerrm);
end;
/


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class EmployeeAgeException extends Exception {
  public EmployeeAgeException(String message) {
    super(message);
  }
}

class EmployeeNameException extends Exception {
  public EmployeeNameException(String message) {
    super(message);
  }
}

class EmployeeSalaryException extends Exception {
  public EmployeeSalaryException(String message) {
    super(message);
  }
}

class EmployeeEmailException extends Exception {
  public EmployeeEmailException(String message) {
    super(message);
  }
}

class EmployeeDojException extends Exception {
  public EmployeeDojException(String message) {
    super(message);
  }
}

class Employee {
  public String name;
  public int age;
  public String email;
  public int salary;
  public Date doj;

  public Employee(String name, int age, String email, int salary, Date doj) throws EmployeeAgeException,
      EmployeeNameException, EmployeeSalaryException, EmployeeEmailException, EmployeeDojException {
    if (age <= 0) {
      throw new EmployeeAgeException("Age should be greater than 0.");
    }

    if (name.matches(".*\\d.*")) {
      throw new EmployeeNameException("Name should not contain any special characters.");
    }

    if (name.length() < 5) {
      throw new EmployeeNameException("Name should be greater than 5 characters.");
    }

    if (salary <= 0) {
      throw new EmployeeSalaryException("Salary should be greater than 0.");
    }

    if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
      throw new EmployeeEmailException("Email should be in proper format.");
    }

    if (doj.before(new Date())) {
      throw new EmployeeDojException("DOJ should be today or future date.");
    }

    this.name = name;
    this.age = age;
    this.email = email;
    this.salary = salary;
    this.doj = doj;
  }

  public void display() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Email: " + email);
    System.out.println("Salary: " + salary);
    System.out.println("DOJ: " + doj);
  }
}

public class Excercise52 {
  public static void main(String[] args) {
    Employee[] employees = new Employee[5];

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 5; i++) {

      System.out.print("Enter name: ");
      String name = sc.nextLine();

      System.out.print("Enter age: ");
      int age = sc.nextInt();

      sc.nextLine();

      System.out.print("Enter email: ");
      String email = sc.nextLine();

      System.out.print("Enter salary: ");
      int salary = sc.nextInt();

      sc.nextLine();

      System.out.print("Enter DOJ (in the format dd/MM/yyyy): ");
      String doj_string = sc.nextLine();

      Date doj;

      try {
        doj = formatter.parse(doj_string);
      } catch (Exception e) {
        System.out.println(e);
        continue;
      }

      try {
        employees[i] = new Employee(name, age, email, salary, doj);
        employees[i].display();
      } catch (EmployeeAgeException e) {
        System.out.println(e.getMessage());
      } catch (EmployeeNameException e) {
        System.out.println(e.getMessage());
      } catch (EmployeeSalaryException e) {
        System.out.println(e.getMessage());
      } catch (EmployeeEmailException e) {
        System.out.println(e.getMessage());
      } catch (EmployeeDojException e) {
        System.out.println(e.getMessage());
      }
    }

    sc.close();
  }
}

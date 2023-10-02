// A company has a hierarchy of employees, with the CEO at the top, followed by managers, and supervisors. The company wants to create a program that can calculate the salaries of all of its employees, taking into account their position, experience, and other factors.
//
//  
//
// The program can be implemented using multilevel inheritance. The CEO class can be the superclass, and the Manager and, Supervisor classes can be subclasses of the CEO class. The CEO class can have a method to calculate the base salary of an employee, and the subclasses can override this method to calculate the salary for each type of employee.
//
//  
//
// For example, the Manager class can override the calculateSalary() method to add a bonus to the base salary, based on the manager's performance. The Supervisor class can override the calculateSalary() method to add a bonus to the base salary, based on the supervisor's performance and the number of employees they supervise.
//
//  
//
// The program can also take into account other factors, such as the employee's experience, and skills to receive the maximum bonus. For example, the program can give a higher salary to an employee with more experience, and additional skills.
//
//  
//
// Manager’s Increment (12% to the base salary):
//
// 10% bonus to Experience and 2% to their skills
//
// Experience
//
// Bonus %
//
// More than 10 years
//
// 10%
//
// More than 7.5 to less than 10 years
//
// 8%
//
// More than 5 to less than 7.5 years
//
// 6%
//
// More than 3 to less than 5 years
//
// 3%
//
// Less than 3 years
//
// 0%
//
//  
//
// A manager can eligible to get remaining 2% of bonus if they have any additional skills.
//
// Supervisor’s Increment (12% to the base salary):
//
// 10% bonus to the number of employee’s supervise and 2% to their skills
//
// Number of supervise
//
// Bonus %
//
// More than 10 members
//
// 10%
//
// 8 to 10 members
//
// 8%
//
// 5 to 8 members
//
// 6%
//
// 3 to 5 members
//
// 3%
//
// Less than 3 years
//
// 0%
//
//  
//
// A supervisor can eligible to get remaining 2% of bonus if they have any additional skills
//
//  
//
// Expected Output:
//
// Name of Employee:
//
// Designation of Employee:
//
// Experience:
//
// Additional skills(if any):
//
// Base salary:
//
// Eligible to receive bonus: Yes or No
//
// If Yes, Bonus amount in percentage:
//
// Total salary(Base + Bonus) :

class CEO {
  String name;
  String designation;
  int experience;
  double baseSalary;

  CEO(String name, String designation, int experience, double baseSalary) {
    this.name = name;
    this.designation = designation;
    this.experience = experience;
    this.baseSalary = baseSalary;
  }

  double calculateSalary() {
    return baseSalary;
  }
}

class Manager extends CEO {
  int yearsOfExperience;
  String[] additionalSkills;

  Manager(String name, String designation, int experience, double baseSalary,
      int yearsOfExperience, String[] additionalSkills) {
    super(name, designation, experience, baseSalary); 
    this.yearsOfExperience = yearsOfExperience;
    this.additionalSkills = additionalSkills;
  }

  @Override
  double calculateSalary() {
    double salary = super.calculateSalary();
    double bonus = 0.0;
    if (yearsOfExperience > 10) {
      bonus = salary * 0.1;
    } else if (yearsOfExperience > 7.5) {
      bonus = salary * 0.08;
    } else if (yearsOfExperience > 5) {
      bonus = salary * 0.06;
    } else if (yearsOfExperience > 3) {
      bonus = salary * 0.03;
    }
    if (additionalSkills.length > 0) {
      bonus += salary * 0.02;
    }
    return salary + bonus;
  }
}

class Supervisor extends Manager {
  int noOfEmployeesToSupervise;

  Supervisor(String name, String designation, int experience, double baseSalary,
      int yearsOfExperience, String[] additionalSkills, int noOfEmployeesToSupervise) {
    super(name, designation, experience, baseSalary, experience, additionalSkills);
    this.noOfEmployeesToSupervise = noOfEmployeesToSupervise;
  }

  @Override
  double calculateSalary() {
    double salary = super.calculateSalary();
    double bonus = 0.0;
    if (noOfEmployeesToSupervise > 10) {
      bonus = salary * 0.1;
    } else if (noOfEmployeesToSupervise > 8) {
      bonus = salary * 0.08;
    } else if (noOfEmployeesToSupervise > 5) {
      bonus = salary * 0.06;
    } else if (noOfEmployeesToSupervise > 3) {
      bonus = salary * 0.03;
    }
    return salary + bonus;
  }
}

public class InheritanceWorkout {
  public static void main(String[] args) {
    CEO ceo = new CEO("Milind", "CEO", 15, 100000.0);
    Manager manager = new Manager("Ishaan", "Manager", 10, 50000.0, 5, new String[] {"Java", "Python"});
    Supervisor supervisor = new Supervisor("Param", "Supervisor", 5, 25000.0, 2, new String[] {"Java"}, 5);
    System.out.println("CEO Salary: " + ceo.calculateSalary());
    System.out.println("Manager Salary: " + manager.calculateSalary());
    System.out.println("Supervisor Salary: " + supervisor.calculateSalary());
  }
}

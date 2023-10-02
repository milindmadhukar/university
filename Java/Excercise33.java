// 1.  Write a Java program to create a class named Student that has the following fields in private: name (String), rollNo (int), marks (double array of size 5), and average (double). The class should have the following methods:
//
// A static method named calculateAverage takes a type double in an array as a parameter and returns the average of its elements.
//
// A default constructor that initializes the name to “Unknown”, rollNo to 0, marks to {0, 0, 0, 0, 0}, and average to 0.
//
// A parameterized constructor that takes a String, an int, and a double array as parameters and assigns them to the name, rollNo, and marks fields respectively. It should also call the calculateAverage method and assign its return value to the average field.
//
// A copy constructor that takes another Student object as a parameter and copies its fields to the current object.
//
// A toString method that returns a String representation of the Student object in the format: “Name: name, Roll No: rollNo, Marks: marks[0], marks1, marks2, marks3, marks4, Average: average”.
//
// Create a driver class, declare main method and create an array of Student objects of size 3 and initialize them using different constructors. It should then display the details of each Student object using the toString method.
//
//
//
// 2. Write a Java program to create a class named Employee that has the following fields: name (String), id (int), salary (double), and bonus (double). The class should have the following methods:
//
// A private default constructor that initializes the name to “Unknown”, id to 0, salary to 0, and bonus to 0.
//
// A private parameterized constructor that takes a String, an int, and a double as parameters and assigns them to the name, id, and salary fields respectively. It should also calculate the bonus as 10% of the salary and assign it to the bonus field.
//
// A toString method that returns a String representation of the Employee object in the format: “Name: name, ID: id, Salary: salary, Bonus: bonus”.
//
// Write a driver class that should create two Employee objects and invoke the constructors using reflection and displays their details using the toString method.

import java.lang.reflect.Constructor;

class Student {
  private String name;
  private int rollNo;
  private double[] marks;
  private double average;

  public static double calculateAverage(double[] marks) {
    double sum = 0;
    for (int i = 0; i < marks.length; i++) {
      sum += marks[i];
    }
    return sum / marks.length;
  }

  public Student() {
    this.name = "Unknown";
    this.rollNo = 0;
    this.marks = new double[5];
    this.average = 0;
  }

  public Student(String name, int rollNo, double[] marks) {
    this.name = name;
    this.rollNo = rollNo;
    this.marks = marks;
    this.average = calculateAverage(marks);
  }

  public Student(Student student) {
    this.name = student.name;
    this.rollNo = student.rollNo;
    this.marks = student.marks;
    this.average = student.average;
  }

  public String toString() {
    String marksString = "";
    for (int i = 0; i < marks.length; i++) {
      marksString += marks[i] + ", ";
    }
    return "Name: " + name + ", Roll No: " + rollNo + ", Marks: " + marksString + "Average: " + average;
  }
}

class Employee {
  private String name;
  private int id;
  private double salary;
  private double bonus;

  private Employee() {
    this.name = "Unknown";
    this.id = 0;
    this.salary = 0;
    this.bonus = 0;
  }

  private Employee(String name, int id, double salary) {
    this.name = name;
    this.id = id;
    this.salary = salary;
    this.bonus = salary * 0.1;
  }

  public String toString() {
    return "Name: " + name + ", ID: " + id + ", Salary: " + salary + ", Bonus: " + bonus;
  }
}

class Main {
  public static void main(String[] args) throws Exception {
    Student[] students = new Student[3];
    students[0] = new Student();
    students[1] = new Student("Milind", 100, new double[] { 1, 2, 3, 4, 5 });
    students[2] = new Student(students[1]);

    for (int i = 0; i < students.length; i++) {
      System.out.println(students[i]);
    }

    System.out.println();

    Constructor<Employee> defaultConstructor = Employee.class.getDeclaredConstructor();
    defaultConstructor.setAccessible(true);
    Employee employee1 = defaultConstructor.newInstance();

    Constructor<Employee> parameterizedConstructor = Employee.class.getDeclaredConstructor(String.class, int.class,
        double.class);
    parameterizedConstructor.setAccessible(true);

    Employee employee2 = parameterizedConstructor.newInstance("Milind", 10, 50000);

    System.out.println(employee1);
    System.out.println(employee2);

  }
}

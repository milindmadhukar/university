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

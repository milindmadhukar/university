// 1. Write a program in Java to create two date objects. One for startDate and another endDate. Then calculate the difference between the two dates in milliseconds. Finally, converts the difference in milliseconds to days and prints the number of days, hours, minutes, and seconds between the two days. 
//
// Note: Use the appropriate methods of the Date class
//
// 2. Write a Java program that prompts the user to enter their date of birth in the format dd/mm/yyyy and displays their age in years, months, and days as of today
//
// Note: Use LocalDate, Period class, and its methods
//
// 3. Write a program that generates a random date between January 1, 2020, and December 31, 2020, and displays it in the format dd/mm/yyyy. Use the Math.random() method to generate random numbers.
//
// Note: Use LocalDate, Random class, and ofEpoch( ) method
//
// Use parse( ) method in all the programs to format the date and time
//
//
//  Design a Java program that simulates a multi-level educational institution's enrollment system using nested classes. Create an outer class named "Institution" that contains information about the institution such as its name and location in private. Declare a constructor for the outer class and initialize the value from the object. Inside the "Institution" class, define a static inner class named "Department" to represent various academic departments within the institution. Each "Department" should have a unique ID, name, and specialization in private and it should initialized through the constructor from the object.
//
// Furthermore, within each "Department," define another inner class named "Student" as a static class. The "Student" class should have attributes like student ID, name, age, and courses enrolled. Use the constructor to initialize the value. Implement methods to add new students to the department, enroll them in courses, and display student information.
//
// In the driver class, create an object of outer and inner class, access the static nested classes using the outer class name, invoke the methods of inner class using inner class objects.import java.util.Date;
// import java.util.Scanner;
// import java.time.LocalDate;
// import java.time.Period;
// import java.text.SimpleDateFormat;

class Program1 {
  Date startDate, endDate;

  public Program1(Date startDate, Date endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public long getDifferenceinMs() {
    return endDate.getTime() - startDate.getTime();
  }

  public void display() {
    long ms = getDifferenceinMs();
    System.out.println("Difference in milliseconds: " + ms);
    System.out.println("Difference in days: " + ms / (1000 * 60 * 60 * 24));
    System.out.println("Difference in hours: " + ms / (1000 * 60 * 60));
    System.out.println("Difference in minutes: " + ms / (1000 * 60));
    System.out.println("Difference in seconds: " + ms / (1000));
  }
}

class Program2 {
  LocalDate dob;
  Period p;

  public Program2(int day, int month, int year) {
    LocalDate today = LocalDate.now();
    dob = LocalDate.of(year, month, day);
    p = Period.between(dob, today);
  }

  public void display() {
    System.out.println("Your are " + p.getYears() + " years, " + p.getMonths() + " months and " + p.getDays()
        + " days old.");
  }
}

class Program3 {
  LocalDate randomDate;

  public Program3() {
    LocalDate startDate = LocalDate.of(2020, 1, 1);
    LocalDate endDate = LocalDate.of(2020, 12, 31);

    long startEpochDay = startDate.toEpochDay();
    long endEpochDay = endDate.toEpochDay();

    long randomDay = startEpochDay + (long) (Math.random() * (endEpochDay - startEpochDay));
    randomDate = LocalDate.ofEpochDay(randomDay);
  }

  public void display() {
    System.out.println("Random date: " + randomDate);
  }

}


class Institution {
  private String name, location;

  public Institution(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public void showInstitionDetails() {
    System.out.println("Institution Name: " + name);
    System.out.println("Institution Location: " + location);
  }

  static class Department {
    private int id;
    private String name, specialization;

    public Department(int id, String name, String specialization) {
      this.id = id;
      this.name = name;
      this.specialization = specialization;
    }

    static class Student {
      private int id, age;
      private String name;
      private String[] courses;

      public Student(int id, int age, String name, String[] courses) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.courses = courses;
      }

      public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Courses: ");
        for (String course : courses) {
          System.out.println(course);
        }
      }
    }


    Student[] students = new Student[100];

    public void addStudent(int id, int age, String name, String[] courses) {
      Student s = new Student(id, age, name, courses);
      s.display();
      students[id] = s;
    }

    public void display() {
      System.out.println("Department ID: " + id);
      System.out.println("Department Name: " + name);
      System.out.println("Department Specialization: " + specialization);
    }
  }

}


class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Date startDate = new Date();
    Date endDate = new Date();

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Enter start date in the format dd/mm/yyyy: ");
    String inpDate1 = sc.nextLine();

    System.out.print("Enter end date in the format dd/mm/yyyy: ");
    String inpDate2 = sc.nextLine();

    try {
      startDate = formatter.parse(inpDate1);
      endDate = formatter.parse(inpDate2);
    } catch (Exception e) {
      System.out.println(e);
    }

    Program1 p1 = new Program1(startDate, endDate);
    p1.display();

    System.out.println();

    System.out.println("Enter your date of birth in the format dd/mm/yyyy");
    String dob = sc.nextLine();
    String[] dobArr = dob.split("/");
    int day = Integer.parseInt(dobArr[0]);
    int month = Integer.parseInt(dobArr[1]);
    int year = Integer.parseInt(dobArr[2]);

    Program2 p2 = new Program2(day, month, year);
    p2.display();

    System.out.println();

    Program3 p3 = new Program3();
    p3.display();

    System.out.println();

    sc.close();

    Institution i = new Institution("VIT", "Vellore");
    i.showInstitionDetails();

    System.out.println();

    Institution.Department d = new Institution.Department(1, "CSE", "Blockchain");


    // call addStudent
    String[] courses = { "CSE101L", "CSE102L" };
    d.addStudent(1, 19, "Milind", courses);
    d.addStudent(2, 20, "Martin Garrix", courses);

    Institution.Department.Student s = new Institution.Department.Student(3, 20, "Test", courses);
    s.display();

    System.out.println();

    d.display();
  }
}

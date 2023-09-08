import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.text.SimpleDateFormat;

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

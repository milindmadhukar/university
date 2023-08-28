import java.util.Scanner;
import java.util.Arrays;

class Innings {
  public String number, battingTeam;
  public long runs;

  Scanner sc = new Scanner(System.in);

  Innings() {
    System.out.println("Enter innings number, batting team and runs scored: ");
    number = sc.nextLine();
    battingTeam = sc.next();
    runs = sc.nextLong();
  }

  public void displayInningsDetails() {
    System.out.println("Innings Details:");
    System.out.println("Innings Number: " + number);
    System.out.println("Batting Team: " + battingTeam);
    System.out.println("Runs Scored: " + runs);
  }
}

class TheoryCourse {
  float testMarks[] = new float[3];
  String courseCode, courseTitle;

  float dComponent; // Average of 2 best tests
  float eComponent; // Assignment presentation
  float fComponent; // Objective test 1
  float gComponent; // Objective test 2
  float hComponent; // Total CA
  float iComponent; // Final exam
  float jComponent; // Total marks

  Scanner sc = new Scanner(System.in);

  TheoryCourse(String courseCode, String courseTitle) {

    this.courseCode = courseCode;
    this.courseTitle = courseTitle;

    System.out.print("Enter test 1 marks: ");
    testMarks[0] = sc.nextFloat();

    System.out.print("Enter test 2 marks: ");
    testMarks[1] = sc.nextFloat();

    System.out.print("Enter test 3 marks: ");
    testMarks[2] = sc.nextFloat();

    System.out.print("Enter assignment presentation marks: ");
    eComponent = sc.nextFloat();

    System.out.print("Enter objective test 1 marks: ");
    fComponent = sc.nextFloat();

    System.out.print("Enter objective test 2 marks: ");
    gComponent = sc.nextFloat();

    Arrays.sort(testMarks);

    dComponent = (testMarks[1] + testMarks[2]) / 2.0f;

    hComponent = dComponent + eComponent + fComponent + gComponent;

    System.out.print("Enter final exam marks: ");
    iComponent = sc.nextFloat();

    jComponent = hComponent + iComponent;
  }

  void display() {
    System.out.println("Course Code: " + courseCode);
    System.out.println("Course Title: " + courseTitle);
    System.out.println("Total Marks: " + jComponent);
  }

}

class LabCourse {

  String courseCode, courseTitle;

  float aComponent; // Observation1
  float bComponent; // Individual report 1
  float cComponent; // Observation 2
  float dComponent; // Individual report 2

  float eComponent; // Total CA

  float fComponent; // Viva voce
  float gComponent; // Final exam

  float hComponent; // Total marks

  Scanner sc = new Scanner(System.in);

  LabCourse(String courseCode, String courseTitle) {

    this.courseCode = courseCode;
    this.courseTitle = courseTitle;

    System.out.print("Enter observation 1 marks: ");
    aComponent = sc.nextFloat();

    System.out.print("Enter individual report 1 marks: ");
    bComponent = sc.nextFloat();

    System.out.print("Enter observation 2 marks: ");
    cComponent = sc.nextFloat();

    System.out.print("Enter individual report 2 marks: ");
    dComponent = sc.nextFloat();

    eComponent = aComponent + bComponent + cComponent + dComponent;

    System.out.print("Enter viva voce marks: ");
    fComponent = sc.nextFloat();

    System.out.print("Enter final exam marks: ");
    gComponent = sc.nextFloat();

    hComponent = eComponent + fComponent + gComponent;

  }

  void display() {
    System.out.println("Course Code: " + courseCode);
    System.out.println("Course Title: " + courseTitle);
    System.out.println("Total Marks: " + hComponent);
  }
}

class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Innings innings = new Innings();
    innings.displayInningsDetails();

    System.out.println();

    System.out.println("Enter number of courses: ");
    int numberOfCourses = sc.nextInt();

    sc.nextLine();

    for (int i = 0; i < numberOfCourses; i++) {

      System.out.print("Enter course code: ");
      String courseCode = sc.nextLine();

      System.out.print("Enter course title: ");
      String courseTitle = sc.nextLine();

      char theoryOrLab = courseCode.charAt(3);

      if (theoryOrLab == 'T') {
        TheoryCourse theoryCourse = new TheoryCourse(courseCode, courseTitle);
        theoryCourse.display();
      } else if (theoryOrLab == 'L') {
        LabCourse labCourse = new LabCourse(courseCode, courseTitle);
        labCourse.display();
      } else {
        System.out.println("Invalid course code");
        i--;
      }
    }

    sc.close();
  }
}

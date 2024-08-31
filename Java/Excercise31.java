// 1. Write a Java program to Create a class named Innings with the following public member variables / Attributes
//
//
//
// Include a method in the class named displaylnningsDetails.In This method, display The details of The innings in The format shown in The sample output. This method does not accept any arguments and its return type is void.
//
// Create another class named Main and write a main method to test the above class.
//
// Input Format
//
// The First line Consists of a String
//
// The Second line consists of a String that represents the batting team The next Line consists of a Long that represents how many runs scored
//
// Output Format
//
// The Output Should display the InningsDetails
//
// Sample Input:
// First Innings
// IND
// 190
//
// Sample Output:
// Innings Details
// Innings number: First Innings
// Batting Team: IND
// Run Scored: 190
//
// 2. 
//
// A CSE student has to study theory and lab courses each semester. Each course has a code (e.g. 19Z311) and a title (“Object-oriented Programming Laboratory”).
//
// Each theory course has the following continuous assessment (CA) components:
//
//
// Each lab course has the following continuous assessment (CA) components:
//
//
//
// Design a single class to represent a theory as well as a lab course. Create instance variables for “Course code”, “Course title”, and “Total Marks”
//
// Create 2 user-defined methods:
// 1. Calculate the total marks for the theory course from the components of Table 1 and Table 2.
// 2. Calculate the total marks for the lab course from the components of Table 3 and Table 4.
//
// Input Format:
//
// The first line of the input contains the total number of courses in the semester(Theorycourse and Labcourse) followed by the next line of the Enter the Theorycourse or Labcourse. For Theorycourse user can be given the following inputs:-
//
// 1. Enter the course code.
//
// 2. Enter the course Title.
//
// 3. Enter the test 1 Mark.
//
// 4. Enter the test 2 Mark.
//
// 5. Enter the test 3 mark.
//
// 6. Enter the Assignment Presentation, Mark.
//
// 7. Enter the Objective Test Mark 1.
//
// 8. Enter the Objective Test Mark 1.
//
// 9. Enter the Final Exam Mark.
//
// For Labcourse users can be given the following inputs:- 1. Enter the course code.
//
// 2. Enter the course Title.
//
// 3. Enter the Observation 1 Mark.
//
// 4. Enter the Individual Report 1 Mark.
//
// 5. Enter the Observation 2 Mark.
//
// 6. Enter the Individual Report 2 Mark.
//
// 7. Enter the viva voice, Mark.
//
// 8. Enter the Final Exam Mark.
//
// Output Format:
//
// Course code: 19ML119
// Course Title: Machine Learning
// Total Marks: 77.5
//
// Course code: 19CC118
// Course Title: Cloud Computing
// Total marks: 83.5import java.util.Scanner;

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

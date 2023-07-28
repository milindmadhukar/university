import java.util.Scanner;

class Experiment1 {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    Experiment1 obj = new Experiment1();
    obj.program1();
    obj.program2();
    obj.program3();
    obj.program4();
    obj.program5();

  }

  void program1() {

    System.out.println("Hello");
    System.out.println("Milind Madhukar");

  }

  void program2() {
    // get 3 integer numbers from the user, compute the average & print the output.
    System.out.println("Enter 3 numbers");
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    float avg = (a + b + c) / 3.0f;

    System.out.println("Average is: " + avg);
  }

  void program3() {
    System.out.println("Output of -5+8*6 is: " + (-5 + 8 * 6));
    System.out.println("Output of (55+9)%9 is: " + ((55 + 9) % 9));
    System.out.println("Output of  20+ -3*5/8 is: " + (20 + -3 * 5 / 8));
    System.out.println("Output of 5+15/3*2-8%3 is: " + (5 + 15 / 3 * 2 - 8 % 3));
  }

  void program4() {
    System.out.println("Enter radius of circle");
    float radius = sc.nextFloat();
    final float pi = 3.1415f;
    float area = pi * radius * radius;
    float perimeter = 2 * pi * radius;

    System.out.println("Area of circle is: " + area);
    System.out.println("Perimeter of circle is: " + perimeter);
  }

  void program5() {

    sc.nextLine();
    
    System.out.print("Enter your registeration number: ");
    String regNo = sc.nextLine();
  
    System.out.print("Enter your name: ");
    String name = sc.nextLine();

    System.out.print("Enter your department: ");
    String dept = sc.nextLine();

    System.out.print("Enter your age: ");
    int age = sc.nextInt();

    System.out.print("Enter your mobile number: ");
    long mobileNo = sc.nextLong();

    System.out.print("Enter your GPA: ");
    float gpa = sc.nextFloat();


    System.out.println("Register_No: " + regNo);
    System.out.println("Name: " + name);
    System.out.println("Dept: " + dept);
    System.out.println("Age: " + age);
    System.out.println("Mobile_No: " + mobileNo);
    System.out.println("GPA: " + gpa);
  }
}

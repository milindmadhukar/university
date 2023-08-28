import java.util.Scanner;

class Excercise23 {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Excercise23 obj = new Excercise23();
    obj.program1();
    obj.program2();
    obj.program3();

    int diff = obj.string1();
    System.out.println("Difference: " + diff + "\n");
    obj.string2();
    obj.string3();
    obj.string4();
    obj.string5();
  }

  void program1() {
    System.out.print("Employee Name: ");
    String name = sc.nextLine();

    System.out.print("Hours worked: ");
    int hours = sc.nextInt();

    System.out.print("Pay rate: ");
    double rate = sc.nextDouble();

    double grossPay = hours * rate;
    double federalWithholding = grossPay * 0.2;
    double stateWithholding = grossPay * 0.09;
    double totalDeduction = federalWithholding + stateWithholding;
    double netPay = grossPay - totalDeduction;

    System.out.println("Gross pay: " + grossPay);
    System.out.println("Deductions: ");
    System.out.println("\tFederal Withholding (20.0%): " + federalWithholding);
    System.out.println("\tState withholding (9.0%): " + stateWithholding);
    System.out.println("\tTotal Deduction: " + totalDeduction);
    System.out.println("Net pay: " + netPay);

    System.out.println();
  }

  void program2() {
    String plateNumber = "";

    for (int i = 0; i < 3; i++) {
      plateNumber += (char) ((Math.random() * 26) + 65);
    }

    for (int i = 0; i < 4; i++) {
      plateNumber += (int) (Math.random() * 10);
    }

    System.out.println("Plate number: " + plateNumber);
    System.out.println();
  }

  void program3() {

    System.out.print("Enter a year: ");
    int year = sc.nextInt();

    System.out.print("Enter a month: ");
    String month = sc.next();

    int days = 0;

    switch (month) {
      case "Jan":
      case "Mar":
      case "May":
      case "Jul":
      case "Aug":
      case "Oct":
      case "Dec":
        days = 31;
        break;
      case "Apr":
      case "Jun":
      case "Sep":
      case "Nov":
        days = 30;
        break;
      case "Feb":
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
          days = 29;
        } else {
          days = 28;
        }
        break;
      default:
        System.out.println("Invalid month");
        return;
    }

    System.out.println(month + " " + year + " has " + days + " days");
  }

  int string1() {

    sc.nextLine();

    System.out.println("Enter two strings: ");

    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    System.out.println("s1: " + s1);
    System.out.println("s2: " + s2);

    return s1.compareTo(s2);
  }

  void string2() {
    System.out.print("Enter email address: ");
    String email = sc.next();

    int at = email.indexOf('@');
    int dot = email.lastIndexOf('.');

    String domain = email.substring(dot + 1);

    boolean valid;

    if ((at != -1 && dot != -1)
        && (domain.contains("com") || domain.contains("in") || domain.contains("net") || domain.contains("org"))) {
      valid = true;
    } else {
      valid = false;
    }

    System.out.println(email);

    if (valid) {
      System.out.println("Valid email address");
    } else {
      System.out.println("Invalid email address");
    }

    System.out.println();
  }

  void string3() {

    System.out.print("Enter a password: ");
    String password = sc.next();
    boolean isLongerThan8, hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

    isLongerThan8 = password.length() >= 8;
    for (int i = 0; i < password.length(); i++) {
      char c = password.charAt(i);
      if (Character.isUpperCase(c) && !hasUpperCase) {
        hasUpperCase = true;
      } else if (Character.isLowerCase(c) && !hasLowerCase) {
        hasLowerCase = true;
      } else if (Character.isDigit(c) && !hasDigit) {
        hasDigit = true;
      } else if (!Character.isLetterOrDigit(c) && !hasSpecialChar) {
        hasSpecialChar = true;
      }
    }

    boolean valid = isLongerThan8 && hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;

    if (valid) {
      System.out.println("Valid password");
    } else {
      System.out.println("Invalid password");
    }
    System.out.println();
  }

  void string4() {
    sc.nextLine();
    System.out.print("Enter a string: ");
    String s = sc.nextLine();

    int length = s.length();

    if (length % 2 == 0) {
      System.out.println(s.charAt((length / 2) - 1) + ", " + s.charAt(length / 2));
    } else {
      System.out.println(s.charAt(length / 2));
    }

    System.out.println();
  }

  void string5() {
    System.out.print("Enter a number as string: ");
    String s = sc.next();

    try {
      int n = Integer.parseInt(s);
      System.out.println("The number is " + n);

    } catch (Exception e) {
      System.out.println("Invalid input");
    }
  }
}

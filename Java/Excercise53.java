// Create a user-defined exception called MyException that verifies the user's mark. If the user entered a negative mark, MyException would be thrown with the message "Mark is Negative," otherwise it would be thrown with the message "Mark is Positive."

import java.util.Scanner;

class MyException extends Exception {
  MyException(String s) {
    super(s);
  }
}

public class Excercise53 {
  void check_number() throws MyException {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = sc.nextInt();
    if (num < 0) {
      throw new MyException("Mark is Negative");
    } else {
      throw new MyException("Mark is Positive");
    }
  }

  public static void main(String[] args) throws MyException {
    Excercise53 obj = new Excercise53();
    obj.check_number();
  }
}

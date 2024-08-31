import java.util.Scanner;

class Experiment1b {
  Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    Experiment1b obj = new Experiment1b();
    obj.program1();
    obj.program2();
    obj.program3();
    obj.program4();
    obj.program5();
  }

  void program1() {
    System.out.print("Enter a number: ");
    double num = sc.nextDouble();

    String message1 = (num == 0) ? "zero" : (num > 0) ? "positive" : "negative";
    System.out.println(message1);

    double abs = Math.abs(num);

    String message2 = (abs < 1) ? "small" : (abs > 1000000) ? "large" : "";
    System.out.println(message2);
  }

  void program2() {
    System.out.print("Enter first number: ");
    double num1 = sc.nextDouble();

    System.out.print("Enter second number: ");
    double num2 = sc.nextDouble();

    double rounded1 = Math.floor(num1 * 1000) / 1000.0d;
    double rounded2 = Math.floor(num2 * 1000) / 1000.0d;

    System.out.println(rounded1);
    System.out.println(rounded2);

    String message = (rounded1 == rounded2) ? "same" : "different";
    System.out.println(message);
  }

  void program3() {
    System.out.print("Enter registration number: ");
    String reg = sc.next();

    if(reg.charAt(0) == '1') {
      System.out.println("First year");
    }
    else if(reg.charAt(0) == '2'){
      System.out.println("Second year");
    } 
    else if(reg.charAt(0) == '3') {
      System.out.println("Third year");
    }
    else if(reg.charAt(0) == '4') {
      System.out.println("Final year");
    }
    else {
      System.out.println("Year not available");
    }
  }

  void program4() {
    System.out.print("Enter first number: ");
    int num1 = sc.nextInt();

    System.out.print("Enter second number: ");
    int num2 = sc.nextInt();

    int gcd = 1;
    for(int i = 1; i <= num1 && i <= num2; i++) {
      if(num1 % i == 0 && num2 % i == 0) {
        gcd = i;
      }
    }

    if(gcd == 1) {
      System.out.println("Coprime");
    }
    else{
      System.out.println("Not coprime");
    } 
  }

  void program5() {
    System.out.print("Enter a four digit number: ");
    int num = sc.nextInt();

    int ones = num % 10;
    int tens = (num / 10) % 10;
    int hundreds = (num / 100) % 10;
    int thousands = (num / 1000) % 10;

    int reversed = hundreds * 1000 + thousands* 100 + ones * 10 + tens;

    System.out.println(reversed);
  }
}

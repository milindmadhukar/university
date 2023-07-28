import java.util.Scanner;

class HelloWorld {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a");
    int a = sc.nextInt();
    System.out.println("why u enter: " + a); 

    sc.close();
  }
}

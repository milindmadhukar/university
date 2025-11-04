import java.util.Scanner;

public class EuclidsAlgorithm {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    };
    sc.close();
    System.out.println(gcd(a, b));
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    int r = a % b;
    return gcd(b, r);
  }
}


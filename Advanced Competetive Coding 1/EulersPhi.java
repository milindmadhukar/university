import java.util.Scanner;

public class EulersPhi {

  public static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public static int phi(int n) {
    int result = 1;
    for (int i = 2; i < n; i++) {
      if (gcd(i, n) == 1) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      System.out.println("phi(" + i + ") = " + phi(i));
    }

    sc.close();
  }
}

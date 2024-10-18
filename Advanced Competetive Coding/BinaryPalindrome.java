import java.util.Scanner;

public class Solution {

  static int decimalToBinary(int n) {
    int binary = 0;
    int i = 1;
    while (n > 0) {
      binary += (n % 2) * i;
      n /= 2;
      i *= 10;
    }
    return binary;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    int binary = decimalToBinary(n);

    int rev = 0;
    int temp = binary;
    while (temp > 0) {
      rev = rev * 10 + temp % 10;
      temp /= 10;
    }

    if (binary == rev) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
  }
}

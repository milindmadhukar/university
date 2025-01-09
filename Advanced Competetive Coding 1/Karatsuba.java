import java.util.Scanner;

public class Karatsuba {
  public static long karatsuba(int num1, int num2) {
    if (num1 <= 10 || num2 <= 10) {
      return (long) num1 * num2;
    }

    int n = Math.max(Integer.toString(num1).length(), Integer.toString(num2).length());

    int nby2 = n / 2;

    int a = num1 / (int) Math.pow(10, nby2);
    int b = num1 % (int) Math.pow(10, nby2);

    int c = num2 / (int) Math.pow(10, nby2);
    int d = num2 % (int) Math.pow(10, nby2);

    long X = karatsuba(a, c);
    long Y = karatsuba(b, d);
    long Z = karatsuba(a + b, c + d) - X - Y;

    long res = (long) (X * Math.pow(10, n) + Z * Math.pow(10, nby2) + Y);

    return res;
  }

  public static int binaryToDecimal(int num) {
    int decimal = 0;
    int n = 0;
    while (num != 0) {
      int r = num % 10;
      decimal += r * Math.pow(2, n);
      num = num / 10;
      n++;
    }

    return decimal;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int num1b = sc.nextInt();
    int num2b = sc.nextInt();
    sc.close();

    int num1 = binaryToDecimal(num1b);
    int num2 = binaryToDecimal(num2b);

    System.out.println(karatsuba(num1, num2));
  }
}

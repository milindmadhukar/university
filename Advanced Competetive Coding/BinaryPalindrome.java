import java.util.Scanner;

public class BinaryPalindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    String binary = Integer.toBinaryString(n);
    String rev = new StringBuilder(binary).reverse().toString();

    if (binary.equals(rev)) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
  }
}

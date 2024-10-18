import java.util.Scanner;

public class LongestSequenceOfOnesAfterFlippingBit {

  public static int flipBit(int n) {
    if (~n == 0)
      return 32;

    int currentLength = 0;
    int previousLength = 0;
    int maxLength = 1;

    while (n != 0) {
      if ((n & 1) == 1) {
        currentLength++;
      } else {
        maxLength = Math.max(maxLength, currentLength + previousLength + 1);
        previousLength = currentLength;
        currentLength = 0;
      }
      n >>>= 1;
    }

    maxLength = Math.max(maxLength, currentLength + previousLength + 1);

    return maxLength;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    System.out.println(flipBit(n));
  }
}

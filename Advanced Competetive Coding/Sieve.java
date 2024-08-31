import java.util.Arrays;
import java.util.Scanner;

public class Sieve {

  public static int simpleSieve(int limit) {
    boolean[] isPrime = new boolean[limit + 1];

    Arrays.fill(isPrime, true);

    for (int p = 2; p* p <= limit; p++) {
      if (isPrime[p]) {
        for (int i = p * p; i <= limit; i += p) {
          isPrime[i] = false;
        }
      }
    }

    int count = 0;
    for (int i = 2; i <= limit; i++) {
      if (isPrime[i]) {
        System.out.print(i + " ");
        count++;
      }
    }
    System.out.println();
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    simpleSieve(n);

    sc.close();

  }
}

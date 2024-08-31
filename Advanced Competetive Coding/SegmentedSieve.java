import java.util.Arrays;
import java.util.Scanner;

public class SegmentedSieve {

  public static void segmentedSieve(int l, int h) {
    boolean isPrime[] = new boolean[h - l + 1];
    Arrays.fill(isPrime, true);

    if (l == 1)
      l = 2;

    for (int p = 2; p * p <= h; p++) {
      int sm = Math.max(p * p, (l + p - 1) / p * p);

      for (int i = sm; i <= h; i += p) {
        isPrime[i - l] = false;
      }
    }

    for (int i = l; i <= h; i++) {
      if (isPrime[i - l]) {
        System.out.print(i + " ");
      }
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int l = sc.nextInt();
    int h = sc.nextInt();
    segmentedSieve(l, h);
    sc.close();
  }
}

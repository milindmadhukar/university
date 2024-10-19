import java.util.Scanner;

public class MaxProductSubarray {

  public static int maximumProductSubarray(int[] arr) {
    int max = arr[0];
    int min = arr[0];
    int m = arr[0];
    int n = arr.length;

    for (int i = 1; i < n; i++) {
      if (arr[i] > 0) {
        max = Math.max(arr[i], max * arr[i]);
        min = Math.min(arr[i], min * arr[i]);
      } else if (arr[i] == 0) {
        max = 0;
        min = 0;
      } else {
        int temp = max;
        max = Math.max(arr[i], min * arr[i]);
        min = Math.min(arr[i], temp * arr[i]);
      }
      m = Math.max(m, max);
    }

    return m;
  }

  static long findProd(int[] arr, int i, int j) {
    long prod = 1;
    for (int k = i; k < j; k++) {
      prod *= arr[k];
    }
    return prod;
  }

  public static long maximumProductSubarrayBruteforce(int[] arr) {
    long max = 0;
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        max = Math.max(max, findProd(arr, i, j));
      }
    }

    return max;

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();
    System.out.println(maximumProductSubarray(arr));
  }
}

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

  public static long maximumProductSubarrayBruteforce(int[] arr) {
    int max = 0;
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n - 1; j++) {

      }
    }

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

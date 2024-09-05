import java.util.Scanner;

public class MaximumEquilibriumSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int sum = 0;
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      sum += arr[i];
    }

    int sum1 = 0, sum2 = sum;
    int maxIndex = -1;

    for (int i = 0; i < n; i++) {
      sum1 += arr[i];
      sum2 -= arr[i];

      if (sum1 == sum2) {
        maxIndex = i;
      }
    }

    System.out.println(maxIndex + 1);
    sc.close();
  }
}

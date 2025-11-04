import java.util.Scanner;

public class MaximumEquilibriumSum {
  public static int getMaxEquilibriumSumOptimized(int[] arr) {
    int totalSum = 0;
    for (int i = 0; i < arr.length; i++) {
      totalSum += arr[i];
    }

    int maxSum = Integer.MIN_VALUE;
    int rightSum = totalSum;
    int leftSum = 0;
    for (int i = 0; i < arr.length; i++) {

      rightSum -= arr[i];
      if (leftSum == rightSum && leftSum > maxSum) {
        maxSum = leftSum;
      }
      leftSum += arr[i];
    }
    return maxSum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] input = sc.nextLine().split(" ");
    int n = input.length;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    sc.close();
    int maxSum = getMaxEquilibriumSumOptimized(arr);
    System.out.println(maxSum);
  }

}

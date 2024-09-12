import java.util.Scanner;

public class MaximumEquilibriumSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String inp = sc.nextLine();
    // Split on space and convert to integer
    String[] inpArr = inp.split(" ");

    int n = inpArr.length;

    int arr[] = new int[n];

    int sum = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(inpArr[i]);
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

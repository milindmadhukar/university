import java.util.Scanner;

public class LeadersInArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      int max = arr[n - 1];
      String output = String.valueOf(max);

      for (int i = n - 2; i >= 0; i--) {
        if (arr[i] >= max) {
          max = arr[i];
          output = arr[i] + " " + output;
        }
      }

      System.out.println(output);
    }

    sc.close();
  }
}

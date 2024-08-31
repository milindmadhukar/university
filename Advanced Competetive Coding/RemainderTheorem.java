import java.util.Scanner;

public class RemainderTheorem {

  public static int findMinX(int nums[], int rems[], int n) {
    int x = 0;
    boolean found = false;
    while (!found) {
      found = true;
      x++;
      for (int i = 0; i < n; i++) {
        if (x % nums[i] != rems[i]) {
          found = false;
          break;
        }
      }
    }
    return x;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int nums[] = new int[n];
    int rems[] = new int[n];

    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      rems[i] = sc.nextInt();
    }
    sc.close();

    System.out.println(findMinX(nums, rems, n));
  }
}

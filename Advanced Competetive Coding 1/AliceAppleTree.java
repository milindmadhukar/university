import java.util.*;

class AliceAppleTree {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int apples = sc.nextInt();
    int count = 0, sum = 0;

    while (sum < apples) {
      count++;
      sum += (12 * count * count);
    }

    System.out.print(8 * count);

    sc.close();
  }
}

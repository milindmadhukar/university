import java.util.HashMap;
import java.util.Scanner;

public class Strobogrammatic {

  static HashMap<Integer, Integer> nummap = new HashMap<>();

  public static boolean isStrobogrammtic(int n) {
    int ncpy = n;

    int m = 0;

    while (ncpy != 0) {
      int digit = ncpy % 10;
      if (!nummap.containsKey(digit)) {
        return false;
      }

      m = m * 10 + nummap.get(digit);

      ncpy /= 10;
    }

    return m == n;
  }

  public static void main(String[] args) {
    nummap.put(0, 0);
    nummap.put(1, 1);
    nummap.put(6, 9);
    nummap.put(8, 8);
    nummap.put(9, 6);

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    if (isStrobogrammtic(n)) {
      System.out.println("Strobogrammatic");
    } else {
      System.out.println("Not Strobogrammatic");
    }

    sc.close();
  }
}

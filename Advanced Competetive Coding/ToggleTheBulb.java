import java.util.Scanner;

class ToggleTheBulb {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    boolean isOn[] = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
       for (int j = i; j <= n; j += i) {
        isOn[j] = !isOn[j];
      }
    }

    int on = 0;

    for (int i = 1; i <= n; i++) {
      if (isOn[i]) {
        on++;
      }
    }

    System.out.println(on);
  }
}

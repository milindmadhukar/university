import java.util.Scanner;

public class RemainderTheorem {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int ai[] = new int[n];
    int mi[] = new int[n];

    for (int i = 0; i < n; i++) {
      ai[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      mi[i] = sc.nextInt();
    }
    sc.close();

    int M = 1;
    for (int i = 0; i < n; i++) {
      M *= mi[i];
    }

    int Mi[] = new int[n];

    for (int i = 0; i < n; i++) {
      Mi[i] = M / mi[i];
    }

    int Minvi[] = new int[n];
    for (int i = 0; i < n; i++) {
      // M * something % mi = 1
      System.out.println("Mi[i] for i = " + i + ": " + Mi[i] + "mi[i]: " + mi[i]);
      int Minv = 1;
      while (((Mi[i] * Minv) % mi[i]) != 1) {
        Minv++;
      }
      System.out.println(Minv);

      Minvi[i] = Minv;
    }
    int X = 0;
    for (int i = 0; i < n; i++) {
      System.out.println((ai[i] + " * " + Mi[i] + " * " + Minvi[i]));
      X += (ai[i] * Mi[i] * Minvi[i]);
    }

    System.out.println(X);

    X %= M;

    System.out.println(X);
  }
}

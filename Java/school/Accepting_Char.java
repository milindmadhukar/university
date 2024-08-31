import java.util.Scanner;

class Accepting_Char {

  public static void main(String[] args) {
    int i, n, j;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a Word: ");
    String s = sc.next();
    sc.close();
    n = s.length();
    for (i = 0; i < n; i++) {
      for (j = 0; j <= i; j++) {
        char ch = s.charAt(j);
        System.out.print(ch);
      }
      System.out.println();
    }
  }
}

import java.util.*;

class Binary_Search_String {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a[] = { "Afrojack", "DJ Suresh", "DVLM", "Hardwell", "Martin Garrix", "Zedd" };
    boolean flag = false;
    int l = 0, u = a.length - 1, m = 0;
    String s = "";
    System.out.print("Enter String To Search : ");
    s = sc.nextLine().trim();
    sc.close();
    while (l <= u) {
      m = (l + u) / 2;
      if (s.compareTo(a[m]) > 0)
        l = m + 1;
      else if (s.compareTo(a[m]) < 0)
        u = m - 1;
      else {
        flag = true;
        break;
      }
    }
    if (flag)
      System.out.println("String Found at " + (m + 1) + " location !");
    else
      System.out.println("String Not Found !");
  }
}

public class Practice {
  public static void tower(int n, char beg, char aux, char end) {
    if (n == 1) {
      System.out.println(beg + " " + end);
    } else {
      tower(n - 1, beg, end, aux);
      tower(1, beg, aux, end);
      tower(n - 1, aux, beg, end);
    }
  }

  public static void main(String[] args) {
    tower(3, 'a', 'b', 'c');
  }
}

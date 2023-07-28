class Prototype {
  public static void main(String[] args) {
    System.out.println("Hello, World!");
    final int a;
    a = 5;
    System.out.println(a);
  }

  public int swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    return a;
  }
}

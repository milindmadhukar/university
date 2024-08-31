class ABCDE {
  public static void main(String[] args) {
    char ch = 'A';
    for (int r = 1; r <= 5; r++) {
      for (int c = 1; c <= r; c++, ch++)
        System.out.print(ch + " \n");

    }
  }
}

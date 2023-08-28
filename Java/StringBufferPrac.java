class StringBufferPrac {
  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer("Hello");
    sb.insert(5, "Java");
    System.out.println(sb);
    sb.replace(5, 9, "World");
    System.out.println(sb);
    sb.delete(5, 10);
    System.out.println(sb);
    sb.reverse();
    System.out.println(sb);
    System.out.println(sb.capacity());
  }
}

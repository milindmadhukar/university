public class Permutations {

  static void Permute(String s, String answer) {

    if (s.length() == 0) {
      System.out.print(answer + " ");
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      String left_substr = s.substring(0, i);
      String right_substr = s.substring(i + 1);
      String rest = left_substr + right_substr;
      Permute(rest, answer + ch);
    }
  }

  public static void main(String[] args) {
    String word = "iiii";
    Permute(word, "");
  }
}

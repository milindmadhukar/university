import java.util.*;

class Break_Words_Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a sentence: ");
    String sentence = sc.nextLine().trim() + " ";
    sc.close();
    String words[];
    int count = 0;
    for (int i = 0; i < sentence.length(); i++) {
      if (Character.isWhitespace(sentence.charAt(i))) {
        count++;
      }
    }
    words = new String[count];
    for (int i = 0; i < words.length; i++) {
      words[i] = "";
    }

    int j = 0;
    String temp = "";

    for (int i = 0; i < sentence.length(); i++) {
      if (Character.isWhitespace(sentence.charAt(i))) {
        words[j] = temp;
        temp = "";
        j++;
      } else {
        temp += sentence.charAt(i);
      }
    }

    for (String s : words) {
      System.out.print(s + ", ");
    }
  }
}

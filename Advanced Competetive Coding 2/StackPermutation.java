import java.util.Stack;

public class StackPermutation {
  public static boolean isPossible(int ip[], int op[], int n) {
    Stack<Integer> s = new Stack<>();
    int j = 0;
    for (int i = 0; i < n; i++) {
      s.push(ip[i]);

      while (!s.isEmpty() && s.peek() == op[j]) {
        s.pop();
        j++;
      }
    }

    return s.empty();
  }

  public static void main(String[] args) {
  }
}

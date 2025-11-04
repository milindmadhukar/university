import java.util.Stack;

class FindingCelebrity {

  public static int findCelebrity(int matrix[][], int n) {
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++) {
      s.push(i);
    }

    while (s.size() != 1) {
      int p1 = s.pop();
      int p2 = s.pop();

      if (matrix[p1][p2] == 1) {
        s.push(p2);
      } else {
        s.push(p1);
      }
    }

    int pc = s.pop();

    for (int i = 0; i < n; i++) {
      if (i != pc && (matrix[i][pc] == 0 || matrix[pc][i] == 1)) {
        return -1;
      }
    }

    return pc;
  }

  public static void main(String[] args) {
    int n = 4;
    int matrix[][] = {
        { 0, 0, 1, 0 },
        { 0, 0, 1, 0 },
        { 0, 0, 0, 0 },
        { 0, 0, 1, 0 },
    };

    System.out.println(findCelebrity(matrix, n));
  }
}

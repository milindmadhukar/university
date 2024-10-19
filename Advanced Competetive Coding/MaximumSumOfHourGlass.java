import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOfHourGlass {

  public static int findMaxHourglassSum(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < rows - 2; i++) {
      for (int j = 0; j < cols - 2; j++) {
        int sum = calculateHourglassSum(matrix, i, j);
        maxSum = Math.max(maxSum, sum);
      }
    }

    return maxSum;
  }

  private static int calculateHourglassSum(int[][] matrix, int row, int col) {
    return matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
        matrix[row + 1][col + 1] +
        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
  }

  public static void main(String[] args) {
    Scanner scanner = new java.util.Scanner(System.in);
    List<List<Integer>> matrixList = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim();
      if (line.isEmpty()) {
        break;
      }
      java.util.List<Integer> row = new java.util.ArrayList<>();
      for (String num : line.split("\\s+")) {
        row.add(Integer.parseInt(num));
      }
      matrixList.add(row);
    }

    int[][] matrix = matrixList.stream()
        .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);

    System.out.println(findMaxHourglassSum(matrix));

    scanner.close();
  }
}

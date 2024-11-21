public class Combinations {

  // Program to generate n combinations from an array
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    int n = arr.length;
    int r = 3;
    int[] data = new int[r];
    combination(arr, n, r, 0, data, 0);
  }

  public static void combination(int[] arr, int n, int r, int index, int[] data, int i) {
    if (index == r) {
      for (int j = 0; j < r; j++) {
        System.out.print(data[j] + " ");
      }
      System.out.println();
      return;
    }

    if (i >= n) {
      return;
    }

    data[index] = arr[i];
    combination(arr, n, r, index + 1, data, i + 1);
    combination(arr, n, r, index, data, i + 1);
  }
}

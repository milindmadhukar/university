import java.util.Scanner;

public class BlockSwapAlgorithm {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String inputStr = sc.nextLine();

    int D = sc.nextInt();
    int n = sc.nextInt();

    int[] arr = new int[n];

    String[] numbers = inputStr.split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(numbers[i]);
    }

    D = D % n;

    int newArr[] = new int[n];

    int k = 0;
    for(int i = D - 1; k < n; i++,k++) {
      newArr[k] = arr[i % n];
    }

    for (int i = 0; i < n; i++) {
      System.out.print(newArr[i] + " ");
    }

    sc.close();
  }
}

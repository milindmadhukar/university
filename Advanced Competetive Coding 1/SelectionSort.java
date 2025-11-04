public class SelectionSort {
  public static void main(String[] args) {
  int i, j, pos, small, tmp = 0;
  int arr[] = { 23, 11, 21, 19, 6, 7, 3, 5};

    System.out.println("Orginal array: ");
    for (i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " , ");

    for (i = 0; i < arr.length; i++) {
      small = arr[i];
      pos = i;
      for (j = i + 1; j < arr.length; j++) {
        if (arr[j] < small) {
          small = arr[j];
          pos = j;
        }
      }
      tmp = arr[i];
      arr[i] = arr[pos];
      arr[pos] = tmp;
    }

    System.out.println("\nArray in ascending order : ");
    for (i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " , ");
    }
  }
}


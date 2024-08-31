import java.util.*;

class Binary_Search extends Selection_Sort {
  Scanner sc = new Scanner(System.in);
  int arr[] = { 2, 46, 56, 8, 135, 17, 82, 61, 7 };

  void main() {
    Smain(arr);
    System.out.print("Enter Number to Find : ");
    int n = sc.nextInt();
    boolean flag = false;
    int i = 0, l = 0, u = arr.length - 1, m = 0;
    while (l <= u) {
      m = (l + u) / 2;
      if (n > arr[m])
        l = m + 1;
      else if (n < arr[m])
        u = m - 1;
      else {
        flag = true;
        break;
      }
    }
    if (flag)
      System.out.println("Number Found at " + (m + 1));
    else
      System.out.println("Error Chaar Sow Chaar,Kuch Nahi Mila");
  }
}

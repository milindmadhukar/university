#include <stdio.h>
#include <time.h>

int main() {

  // int arr[8] = {34, 56, 67, 81, 109, 220, 312, 512}; // Best
  // int arr[8] = {512, 312, 220, 109, 81, 67, 56, 34}; // Worst
  int a[8] = {512, 312, 220, 109, 67, 34, 81, 56}; // Average
  //
  //
  int temp, j;
  for(int k=1; k < 8; k++) {
    temp = a[k];
    j = k - 1;
    while(temp >= a[j]) {
      a[j+1] = a[j];
      j--;
    }
    a[j+1] = temp;
  }


  printf("Sorted array is: ");
  for (int k = 0; k < 8; k++) {
    printf("%d, ", a[k]);
  }
}

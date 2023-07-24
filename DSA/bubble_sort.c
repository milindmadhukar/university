#include <stdio.h>

int main() {
  int arr[8] = {512, 10, 220, 109, 81, 67, 56, 34}; // Worst
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8 - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }

  for (int i = 0; i < 8; i++) {
    printf("%d, ", arr[i]);
  }

  return 0;
}


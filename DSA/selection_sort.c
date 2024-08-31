#include <stdio.h>

int main() {
  int arr[8] = {512, 10, 220, 109, 81, 67, 56, 34}; // Worst

  for (int i = 0; i < 8; i++) {
    int smallest_index = i;
    for (int j = i + 1; j < 8; j++) {
      if (arr[j] < arr[smallest_index]) {
        smallest_index = j;
      }
    }
    int temp = arr[i];
    arr[i] = arr[smallest_index];
    arr[smallest_index] = temp;
  }

  for (int i = 0; i < 8; i++) {
    printf("%d, ", arr[i]);
  }
}


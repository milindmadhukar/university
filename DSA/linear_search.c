#include <stdio.h>

int main() {
  int arr[] = {1, 3, 5, 7, 9};
  int n = sizeof(arr) / sizeof(arr[0]);
  int x = 7; // the element we want to search for

  // search for x in the array
  int i;
  for (i = 0; i < n; i++) {
    if (arr[i] == x) {
      printf("%d found at index %d\n", x, i);
      break;
    }
  }

  if (i == n) {
    printf("%d not found in the array\n", x);
  }

  return 0;
}

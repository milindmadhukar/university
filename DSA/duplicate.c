#include <stdio.h>

int main() {
  int arr[10] = {1, 2, 4, 5, 1, 4, 2, 5, 1, 8};

  int unique[10];
  int current = 0;

  for (int i = 0; i < 10; i++) {
    // Check if unique has the number.
    int found = 0;
    for (int j = 0; j < 10; j++) {
      if (arr[i] == unique[j]) {
        found = 1;
        break;
      }
    }
    if (!found) {
      unique[current] = arr[i];
      current++;
    }
  }

  for (int k = 0; k < current; k++) {
    printf("%d ", unique[k]);
  }

  printf("\n");

  return 0;
}

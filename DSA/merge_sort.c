#include <stdio.h>

void mergeSort(int arr[], int l, int r);

int main() {
  int arr[10] = {10, 4, 43, 345, 63, 635, 1, 34, 54, 23};
  mergeSort(arr, 0, 9);
  for (int i = 0; i < 10; i++)
    printf("%d, ", arr[i]);
  printf("\n");
  return 0;
}

void merge(int arr[], int l, int m, int r) {
  int i, j, k;
  int n1 = m - l + 1;
  int n2 = r - m;

  int left[n1], right[n2];

  for (i = 0; i < n1; i++)
    left[i] = arr[l + i];
  for (j = 0; j < n2; j++)
    right[j] = arr[m + 1 + j];

  i = 0;
  j = 0;

  k = l;
  while (i < n1 && j < n2) {
    if (left[i] <= right[j]) {
      arr[k] = left[i];
      i++;
    } else {
      arr[k] = right[j];
      j++;
    }
    k++;
  }

  while (i < n1) {
    arr[k] = left[i];
    i++;
    k++;
  }

  while (j < n2) {
    arr[k] = right[j];
    j++;
    k++;
  }
}

void mergeSort(int arr[], int l, int r) {
  if (l < r) {
    int m = (l + r) / 2;

    mergeSort(arr, l, m);
    mergeSort(arr, m + 1, r);

    merge(arr, l, m, r);
  }
}

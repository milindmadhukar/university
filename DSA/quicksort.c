#include <stdio.h>

void quickSort(int arr[], int left, int right);

int main() {
  int arr[10] = {10, 4, 43, 345, 63, 635, 1, 34, 54, 23};
  quickSort(arr, 0, 9);

  for (int i = 0; i < 10; i++)
    printf("%d, ", arr[i]);

  printf("\n");

  return 0;
}



void swap(int *a, int *b) {
  int t = *a;
  *a = *b;
  *b = t;
}

int partition(int arr[], int beg, int end) {
  int pivot = arr[end];
  int i = (beg - 1);

  for (int j = beg; j <= end; j++) {
    if (arr[j] < pivot) {
      i++;
      swap(&arr[i], &arr[j]);
    }
  }
  swap(&arr[i + 1], &arr[end]);
  return (i + 1);
}

void quickSort(int arr[], int beg, int end) {
  if (beg < end) {
    int pivot = partition(arr, beg, end);
    quickSort(arr, beg, pivot - 1);
    quickSort(arr, pivot + 1, end);
  }
}

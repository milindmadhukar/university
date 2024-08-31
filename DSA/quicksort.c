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

int partition(int arr[], int l, int h) {

  // Random pivot without rand()
  int random = l + rand() % (h - l);
  int pivot = arr[random];



  swap(&arr[l], &arr[random]);

  int i = l;
  int j = h;

  int k = h;
  for (int i = h; i > l; i--) {
    if (arr[i] > pivot) {
      swap(&arr[i], &arr[k]);
      k--;
    }
  }

  swap(&arr[l], &arr[j]);

  return j;
}

void quickSort(int arr[], int beg, int end) {
  if (beg < end) {
    int pivot = partition(arr, beg, end);
    quickSort(arr, beg, pivot - 1);
    quickSort(arr, pivot + 1, end);
  }
}

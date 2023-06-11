// Quick sort algorithm to sort strings

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void swap(char **a, char **b) {
  char *t = *a;
  *a = *b;
  *b = t;
}

int partition(char *arr[], int beg, int end) {
  char *pivot = arr[end];
  int i = (beg - 1);

  for (int j = beg; j <= end; j++) {
    if (strcmp(arr[j], pivot) < 0) {
      i++;
      swap(&arr[i], &arr[j]);
    }
  }
  swap(&arr[i + 1], &arr[end]);
  return (i + 1);
}

void quickSort(char *arr[], int beg, int end) {
  if (beg < end) {
    int pivot = partition(arr, beg, end);
    quickSort(arr, beg, pivot - 1);
    quickSort(arr, pivot + 1, end);
  }
}

int main() {
  char arr[10][10] = {"hello", "world", "this", "is", "a",
                   "test",  "for",   "quick", "sort", "algorithm"};

  quickSort(**arr, 0, 9);

  for (int i = 0; i < 10; i++)
    printf("%s, ", arr[i]);

  printf("\n");

  return 0;
}

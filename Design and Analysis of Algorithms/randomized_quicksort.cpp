#include <iostream>

void swap(int arr[8], int i, int j) {
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

int partition(int arr[], int l, int h) {
  // int random = l + rand() % (h - l);
  int pivot = arr[l];

  // swap(arr, l, random);

  int i = l;
  int j = h;

  int k = h;
  for (int i = h; i > l; i--) {
    if (arr[i] > pivot) {
      swap(arr, i, k);
      k--;
    }
  }

  swap(arr, l, j);

  return j;
}

void quicksort(int arr[], int l, int h) {
  int pivot = partition(arr, l, h);
  quicksort(arr, l, pivot - 1);
  quicksort(arr, pivot + 1, h);
}

int main() {
  int arr[9] = {5, 2, 3, 1, 4, 43, 12, 43, 12};

  quicksort(arr, 0, 8);

  for (int i = 0; i < 8; i++) {
    std::cout << arr[i] << " ";
  }

  return 0;
}

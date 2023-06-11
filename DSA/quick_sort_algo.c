// Quick sort algo to code

#include <stdio.h>


// Function to print the array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Function to swap two elements in an array
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to partition the array and return the pivot index
int partition(int arr[], int beg, int end) {
    int pivot = arr[end];
    int i = (beg - 1);

    for (int j = beg; j <= end; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    i++;
    swap(&arr[i], &arr[end]);
    return (i);
}

// Function to perform quicksort recursively
void quicksort(int arr[], int beg, int end) {
  printArray(arr, end-beg + 1);
    if (beg < end) {
        int pivot = partition(arr, beg, end);
        quicksort(arr, beg, pivot - 1);
        quicksort(arr, pivot + 1, end);
    }
}

// Driver code
int main() {
    int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
    int n = sizeof(arr) / sizeof(arr[0]);
    quicksort(arr, 0, n - 1);
    printf("Sorted array: \n");
    printArray(arr, n);
    return 0;
}

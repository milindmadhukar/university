// Implementation of Binary Search Algorithm.

#include <stdio.h>

int main() {
    int arr[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
    int n = sizeof(arr) / sizeof(arr[0]);  // calculate the length of the array
    int x = 10;  // the value we want to search for
    int left = 0;
    int right = n - 1;
    int mid;

    while (left <= right) {
        mid = (left + right) / 2;
        if (arr[mid] == x) {
            printf("Found %d at index %d\n", x, mid);
            return 0;
        } else if (arr[mid] < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    printf("%d was not found in the array\n", x);
    return 0;
}


#include <stdio.h>

void counting_sort(int A[], int N) {
    // Find the maximum element value in A
    int max = A[0];
    for (int i = 1; i < N; i++) {
        if (A[i] > max) {
            max = A[i];
        }
    }
    
    // Initialize COUNT and RESULT arrays
    int COUNT[max+1];
    int RESULT[N];
    for (int i = 0; i <= max; i++) {
        COUNT[i] = 0;
    }
    
    // Count occurrence of each element in A
    for (int i = 0; i < N; i++) {
        COUNT[A[i]]++;
    }
    
    // Compute cumulative frequency
    for (int i = 1; i <= max; i++) {
        COUNT[i] += COUNT[i-1];
    }
    
    // Sort the elements in A using COUNT array
    for (int i = N-1; i >= 0; i--) {
        RESULT[COUNT[A[i]]-1] = A[i];
        COUNT[A[i]]--;
    }
    
    // Copy the sorted result to A
    for (int i = 0; i < N; i++) {
        A[i] = RESULT[i];
    }
}

int main() {
    int A[] = {5, 5, 7, 2, 7, 3, 9, 6, 8, 1, 4};
    int N = sizeof(A)/sizeof(A[0]);
    
    printf("Original array: ");
    for (int i = 0; i < N; i++) {
        printf("%d ", A[i]);
    }
    printf("\n");
    
    counting_sort(A, N);
    
    printf("Sorted array: ");
    for (int i = 0; i < N; i++) {
        printf("%d ", A[i]);
    }
    printf("\n");
    
    return 0;
}

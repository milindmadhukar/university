// Write a program to Implement Bubble sort algorithm.

#include <stdio.h>
#include <time.h>

int main()
{

    // int arr[8] = {34, 56, 67, 81, 109, 220, 312, 512}; // Best
    int arr[8] = {512, 312, 220, 109, 81, 67, 56, 34}; // Worst
    // int arr[8] = {512, 312, 220, 109, 67, 34, 81, 56}; // Average

    double start, end, time_spent;
    start = clock();

    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 7 - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                int temp = arr[j+1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    end = clock();
    time_spent = (double)(end - start) / CLOCKS_PER_SEC;

    printf("Sorted array is: ");
    for (int k = 0; k < 8; k++){
        printf("%d, ", arr[k]);
    }

    printf("\nTime spent to sort (in ms): %lf\n", time_spent*1000);
}

// Write a program to Implement Selection sort algorithm

#include <stdio.h>

int main()
{

    // int arr[8] = {34, 56, 67, 81, 109, 220, 312, 512}; // Best
    int arr[8] = {512, 312, 220, 109, 81, 67, 56, 34}; // Worst
    // int arr[8] = {512, 312, 220, 109, 67, 34, 81, 56}; // Average

    for (int i = 0; i < 8; i++)
    {
        for (int j = i+1; j < 8; j++)
        {
            if (arr[j] < arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    printf("Sorted array is: ");
    for (int k = 0; k < 8; k++){
        printf("%d, ", arr[k]);
    }
}

#include <stdio.h>
#include <time.h>

int main()
{

    // int arr[8] = {34, 56, 67, 81, 109, 220, 312, 512}; // Best
    // int arr[8] = {512, 312, 220, 109, 81, 67, 56, 34}; // Worst
    int arr[8] = {512, 312, 220, 109, 67, 34, 81, 56}; // Average

    int  j;

    for (int i = 1; i < 8; i++){
        j = i;
        while (arr[j-1] >= arr[j] && j > 0) {
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }
    }


    printf("Sorted array is: ");
    for (int k = 0; k < 8; k++)
    {
        printf("%d, ", arr[k]);
    }
}

#include <stdio.h>

int main() {
    int arr[100];  // declare an array of size 100
    int i = 0, num;

    // read integers until the end of input
    while (scanf("%d", &num) == 1) {
        arr[i] = num;
        i++;
    }

    // print the integers stored in the array
    for (int j = 0; j < i; j++) {
        printf("%d ", arr[j]);
    }
    printf("\n");

    return 0;
}

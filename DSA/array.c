#include <stdio.h>

#define size 5

int main() {
  int arr[size];
  int a;
  a = 10;
  int *ptr;
  ptr = &arr[0];

  *ptr = 10;
  ptr++;
  *ptr = 20;

  // for (int i = 0; i < size; i++) {
  //   scanf("%d", &arr[i]);
  // }
  //
  
  for (int i = 0; i < size; i++) {
    printf("%d, ", arr[i]);
  }

  return 0;
}

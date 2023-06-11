#include <stdio.h>

int main() {
  int n1, n2, *n1_ptr, *n2_ptr;
  printf("Enter 2 numbers: ");
  scanf("%d %d", &n1, &n2);
  n1_ptr = &n1;
  n2_ptr = &n2;

  if (*n1_ptr > *n2_ptr) {
    printf("N1 is larger\n");
  } else {
    printf("N2 is larger\n");
  }
  return 0;
}

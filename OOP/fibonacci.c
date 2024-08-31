#include <stdio.h>


int fibonacci(int n) {
  if (n == 0 || n == 1) // base case
    return n;
  else
    return (fibonacci(n - 1) + fibonacci(n - 2));
}

int main() {
  int terms;
  printf("Enter number of terms: ");
  scanf("%d", &terms);

  for(int i = 0; i <= terms; i++) {
    printf("%d, ", fibonacci(i));
  }

  printf("\n");

  return 0;
}


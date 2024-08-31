#include <stdio.h>

int main() {
  void tower(int n, char beg, char aux, char end);
  tower(4, 'a', 'b', 'c');
  return 0;
}

void tower(int n, char beg, char aux, char end) {
  if (n <= 0)
    printf("Illegal");
  else if (n == 1)
    printf("Move disc from %c to %c\n", beg, end);
  else {
    tower(n - 1, beg, end, aux);
    tower(1, beg, aux, end);
    tower(n - 1, aux, beg, end);
  }
}

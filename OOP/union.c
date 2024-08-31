#include <stdio.h>

int main() {
  union X {
    short num;
    char c[2];
  } u;

  u.num = 32767;

  printf("%d\n", u.num);
  printf("%c\n", u.c[0]);
  printf("%c\n", u.c[1]);
}

// 0100 0001

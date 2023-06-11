#include <stdio.h>

void pattern(char ch, int len) {
  if (len) {
    pattern(ch, len - 1);
  }
  for (int i = 0; i < len; i++) {
    printf("%c ", ch);
  }
  printf("\n");
}

int main() {

  pattern('K', 5);
  return 0;
}

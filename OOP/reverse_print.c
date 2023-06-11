#include <stdio.h>

void rev_print(int n) {
  if (n == 0) {
    return;
  }

  char str[30];
  scanf("%s", str);
  rev_print(n - 1);
  printf("%s\n", str);

}

int main() {
  rev_print(5);
  return 0;
}

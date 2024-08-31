#include <stdio.h>

int main() {
  int num;
  scanf("%d", &num);
  int digits[4];
  int ctr = 0;
  while (num != 0) {
    digits[ctr++] = num % 10;
    num /= 10;
  }

  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4 - i - 1; j++) {
      if (digits[j] > digits[j + 1]) {
        int tmp = digits[j];
        digits[j] = digits[j + 1];
        digits[j + 1] = tmp;
      }
    }
  }

  int sum = digits[0]*10 + digits[2] + digits[1]*10 + digits[3];
  printf("%d", sum);

  return 0;
}

#include <stdio.h>

int main() {
  int dob, sum_odd = 0, sum_even = 0, i = 0;
  printf("Enter date of birth (8 digit number): ");
  scanf("%d", &dob);

  // check if DOB has 8 digits
  int temp = dob;
  int isOdd = 1;
  while (temp != 0) {
    i++;
    if (isOdd) {
      sum_odd += temp % 10;
      isOdd = 0;
    } else {
      sum_even += temp % 10;
      isOdd = 1;
    }
    temp /= 10;
  }
  if (i != 1) {
    printf("Invalid Input");
    return 0;
  }

  // check if DOB is lucky or not
  int result = sum_odd * 3 + sum_even;
  if (result % 10 == 0) {
    printf("%d, Lucky Number.", dob);
  } else {
    printf("%d, Not a Lucky Number.", dob);
  }

  return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LENGTH 1000

int main() {
  char input[MAX_LENGTH];
  char *token;
  int players[MAX_LENGTH], even_nums[MAX_LENGTH], odd_nums[MAX_LENGTH];
  int i = 0, even_count = 0, odd_count = 0;

  fgets(input, MAX_LENGTH, stdin);

  // Splitting input into array.
  token = strtok(input, " ");
  while (token != NULL) {
    players[i++] = atoi(token);
    token = strtok(NULL, " ");
  }

  int valid = 1;

  for(int k = 0; k < i; k++) {
    if (players[k] <= 0) {
      valid = 0;
      break;
    }
  }

  if (!valid) {
    printf("Invalid input, all input must be positive numbers");
    return 0;
  }

  // Separating into even and odd
  for (int k = 0; k < i; k++) {
    if (players[k] % 2) {
      odd_nums[odd_count++] = players[k];
    } else {
      even_nums[even_count++] = players[k];
    }
  }

  // Sort even numbers
  for (int i = 0; i < even_count; i++) {
    for (int j = 0; j < even_count - i - 1; j++) {
      if (even_nums[j] > even_nums[j + 1]) {
        int tmp = even_nums[j];
        even_nums[j] = even_nums[j + 1];
        even_nums[j + 1] = tmp;
      }
    }
  }

  // Sort odd numbers
  for (int i = 0; i < odd_count; i++) {
    for (int j = 0; j < odd_count - i - 1; j++) {
      if (odd_nums[j] > odd_nums[j + 1]) {
        int tmp = odd_nums[j];
        odd_nums[j] = odd_nums[j + 1];
        odd_nums[j + 1] = tmp;
      }
    }
  }

  for (int i = 0; i < odd_count; i++)
    printf("%d ", odd_nums[i]);
  printf("\n");
  for (int i = 0; i < even_count; i++)
    printf("%d ", even_nums[i]);

  return 0;
}

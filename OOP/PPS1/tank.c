
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
  char input[50];
  char *token;
  int tries = 2;

  int tank1_size;
  int tank1_valid = 0;

  while (!tank1_valid) {
    if (tries == 0) {
      printf("You have given invalid input 2 times and more, you cannot "
             "continue. Thanks.\n");
      exit(0);
    }
    scanf("%d", &tank1_size);
    getchar();

    if (tank1_size <= 0) {
      printf("Invalid input, enter details again\n");
      tries--;
    } else if (tank1_size == 1) {
      printf("Invalid, number of elements must be more than 1\n");
      tries--;
    } else {
      tank1_valid = 1;
    }
  }

  int tank1[tank1_size];
  int i = 0;

  fgets(input, 50, stdin);

  // Splitting input into array.
  token = strtok(input, " ");
  while (token != NULL) {
    tank1[i++] = atoi(token);
    token = strtok(NULL, " ");
  }

  int tank2_size;

  int tank2_valid = 0;

  while (!tank2_valid) {
    if (tries == 0) {
      printf("You have given invalid input 2 times and more, you cannot "
             "continue. Thanks.\n");
      exit(0);
    }
    scanf("%d", &tank2_size);
    getchar();

    if (tank2_size <= 0) {
      printf("Invalid input, enter details again\n");
      tries--;
    } else if (tank2_size == 1) {
      printf("Invalid, number of elements must be more than 1\n");
      tries--;
    } else {
      tank2_valid = 1;
    }
  }

  int tank2[tank2_size];

  fgets(input, 50, stdin);
  int j = 0;

  token = strtok(input, " ");

  while (token != NULL) {
    tank2[j++] = atoi(token);
    token = strtok(NULL, " ");
  }

  int combined[tank1_size + tank2_size];
  int count = 0;

  for (int i = 0; i < tank1_size; i++)
    combined[count++] = tank1[i];

  for (int i = 0; i < tank2_size; i++)
    combined[count++] = tank2[i];

  for (int k = 0; k < count; k++) {
    printf("%d ", combined[k]);
  }

  printf("\n");

  for (int i = 0; i < count; i++) {
    for (int j = 0; j < count - i - 1; j++) {
      if (combined[j] > combined[j + 1]) {
        int tmp = combined[j];
        combined[j] = combined[j + 1];
        combined[j + 1] = tmp;
      }
    }
  }

  for (int k = 0; k < count; k++)
    printf("%d ", combined[k]);

  return 0;
}


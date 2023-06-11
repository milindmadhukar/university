#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
  char input[200];
  char *token;

  float earthquake[100];
  int i = 0;

  fgets(input, 200, stdin);

  // Splitting input into array.
  token = strtok(input, " ");
  while (token != NULL) {
    earthquake[i++] = atof(token);
    token = strtok(NULL, " ");
  }

  int low = 0, med = 0, high = 0;

  for(int k = 1; k < i; k++) {
    if (earthquake[k] <= 5.4)
      low++;
    else if(earthquake[k] > 5.4 && earthquake[k] <= 7.0)
      med++;
    else
     high++;
  }

  int count = earthquake[0];

  if(count > 0)
    printf("%d %d %d", low, med, high);
  else if (count == 0)
    printf("No earthquake predicted");
  else
   printf("Invalid Input");

  return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

int main() {

  printf("Start");

  int *a = (int *)calloc(125000000, 4);
  int i = 0;

  printf("Initalized");
  while (i < 125000000) {
    *(a + i) = 10;
  }

  printf("Initalized");

  while (1) {
    printf("Sleeping");
    sleep(1);
  }
}

#include <stdio.h>
#include <string.h>

struct Player {
  char name[100];
  int runs;
};

int main() {
  struct Player player[11];
  for (int i = 0; i < 11; i++) {
    scanf("\n");
    fgets(player[i].name, 100, stdin);
    scanf("%d", &player[i].runs);
  }

  int max = 0;
  char best_batsman[100];
  int total = 0;

  for (int i = 0; i < 11; i++) {
    int current_score = player[i].runs;
    if (current_score > max) {
      max = current_score;
      strcpy(best_batsman, player[i].name);
    }
    total += current_score;
  }

  printf("%d\n%s", total, best_batsman);

  return 0;
}

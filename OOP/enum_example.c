#include <stdio.h>

enum year { Jan=2, Feb=4, Mar = -1, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec };

int main() {
  int i;
  printf("%d\n", Jan);
  printf("%d\n", Dec);
  for (i = Jan; i <= Dec; i++)
    printf("%d ", i);

  return 0;
}

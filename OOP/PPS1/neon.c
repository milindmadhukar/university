#include <stdio.h>

int is_neon(int num) {

  if(num <= 0) {
    return -1;
  }

  int copy = num;
  int sq = num*num;
  int sum = 0;
  while (sq != 0) {
    sum += sq % 10;
    sq /= 10;
  }

  return sum == copy;

}

int main(){
  int num, neon;
  scanf("%d", &num);
  neon = is_neon(num);
  if(neon == 1)
    printf("Yes");
  else if (neon == 0)
    printf("No");
  else
   printf("Invalid");
}

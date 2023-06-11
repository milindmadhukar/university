#include <stdio.h>

void deposit();
void withdraw();

int bal = 30000;

int main() {
  int choice = -1;
  scanf("%d", &choice);
  if (choice == 1)
    withdraw();
  else if (choice == 2)
    deposit();
}

void deposit() {
  int amt;
  scanf("%d", &amt);
  bal += amt;
  printf("%d\n%d", amt, bal);
}

void withdraw() {
  int amt;
  scanf("%d", &amt);
  if (amt > bal) {
    printf("Invalid amount request, check balance.");
    return;
  }

  bal -= amt;
  printf("%d\n%d", amt, bal);
}

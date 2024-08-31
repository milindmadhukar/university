// C program to evaluate value of a postfix expression
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define size 100

int stack[size];
int top = -1;

int pop() {
  if (top == -1) {
    printf("Stack Underflow. Cannot pop.\n");
    return 0;
  }
  int del = stack[top];
  top--;
  return del;
}

void push(int element) {
  if (top == size - 1) {
    printf("Stack Overdlow. Cannot push.\n");
    return;
  }

  top++;
  stack[top] = element;

  return;
}

int evaluatePostfix(char *exp) {
  int i;

  // Scan all characters one by one
  for (i = 0; exp[i]; ++i) {
    if (isdigit(exp[i]))
      push(exp[i] - '0');
    else {
      int val1 = pop();
      int val2 = pop();
      switch (exp[i]) {
      case '+':
        push(val2 + val1);
        break;
      case '-':
        push(val2 - val1);
        break;
      case '*':
        push(val2 * val1);
        break;
      case '/':
        push(val2 / val1);
        break;
      }
    }
  }
  return pop();
}

int main() {
  char exp[] = "231+9";
  printf("postfix evaluation: %d", evaluatePostfix(exp));
  return 0;
}

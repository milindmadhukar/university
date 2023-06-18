#include <stdbool.h>
#include <stdio.h>
#include <string.h>

#define size 1000

char stack[size];
int top = -1;

void push(char e) {
  if (top == size - 1) {
    printf("overflow");
    return;
  }
  stack[++top] = e;
}

int pop() {
  if (top == -1) {
    return '.';
  }

  int e = stack[top--];
  return e;
}

bool is_empty() { return top == -1; }

char get_opposite_bracket(char bracket) {
  if (bracket == '(')
    return ')';
  else if (bracket == '{')
    return '}';
  else if (bracket == '[')
    return ']';
  else if (bracket == ')')
    return '(';
  else if (bracket == '}')
    return '{';
  else if (bracket == ']')
    return '[';
  return '.';
}

bool is_opening_bracket(char curr) {
  if (curr == '(' || curr == '{' || curr == '[')
    return true;
  return false;
}

bool is_closing_bracket(char curr) {
  if (curr == ')' || curr == '}' || curr == ']')
    return true;
  return false;
}

bool is_valid(char str[100]) {
  for (int i = 0; i < strlen(str); i++) {
    char curr = str[i];
    if (is_opening_bracket(curr)) {
      push(curr);
    } else if (is_closing_bracket(curr)) {
      char popped_char = pop();
      if (popped_char == '.')
        return false;
      char opposite_brac = get_opposite_bracket(popped_char);

      while (top != -1) {
        char bracket = pop();
        if (is_opening_bracket(bracket) && bracket == opposite_brac)
          continue;
        else
          return false;
      }
    }
  }
  return top == -1;
}

int main() {
  char expression[1000] = "{]}";
  bool valid = is_valid(expression);
  if (valid) {
    printf("Expression toh jainwin");
  } else {
    printf("Expression toh not jainwin");
  }
  return 0;
}

// Implement the push and pop operations of stack data structure using linked
// list
//
#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *next;
};

struct Stack {
  struct Node *top;
};

void push(struct Stack *s, int element) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  if (node == NULL) {
    printf("Stack overflow, no memory left");
    return;
  }

  node->data = element;
  node->next = NULL;

  node->next = s->top;
  s->top = node;
}

int pop(struct Stack *s) {
  if (s->top == NULL) {
    printf("Stack underflow");
    return -1;
  }

  struct Node *node_to_remove = s->top;
  s->top = s->top->next;

  int e = node_to_remove->data;

  free(node_to_remove);

  return e;
}

void display(struct Stack *stack) {
  struct Node *current = stack->top;
  while (current != NULL) {
    printf("%d ", current->data);
    current = current->next;
  }
  printf("\n");
}

int main() {

  struct Stack *stack = (struct Stack *)malloc(sizeof(struct Stack));

  push(stack, 10);
  push(stack, 20);
  push(stack, 30);
  int e = pop(stack);
  printf("Element removed is: %d\n", e);
  push(stack, 40);
  display(stack);
  pop(stack);
  pop(stack);
  pop(stack);
  pop(stack);

  return 0;
}

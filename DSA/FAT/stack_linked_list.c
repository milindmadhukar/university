// Implement the push and pop operations of stack data structure using linked
// list
#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *next;
};

struct Node *create_node(int data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->next = NULL;
  return node;
}

struct Stack {
  struct Node *top;
};

void push(struct Stack *s, int data) {
  struct Node *node = create_node(data);

  if (node == NULL) {
    printf("No memory left. Stack overflow. Cannot push: %d\n", data);
    return;
  }

  node->next = s->top;
  s->top = node;
}

int pop(struct Stack *s) {
  if (s->top == NULL) {
    printf("Stack underflow, cannot pop.");
    return -1;
  }
  struct Node *popped_node = s->top;
  s->top = s->top->next;
  int e = popped_node->data;
  free(popped_node);
  return e;
}

void display(struct Stack *s) {
  struct Node *current_node = s->top;

  while (current_node != NULL) {
    printf("%d ", current_node->data);
    current_node = current_node->next;
  }

  printf("\n");
}

int main() {

  struct Stack s;
  s.top = NULL;

  push(&s, 20);
  push(&s, 30);
  push(&s, 40);
  display(&s);
  printf("We are popping: %d\n", pop(&s));
  printf("We are popping: %d\n", pop(&s));
  printf("We are popping: %d\n", pop(&s));
  printf("We are popping: %d\n", pop(&s));
  printf("We are popping: %d\n", pop(&s));
}
//

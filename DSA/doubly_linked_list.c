#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *prev;
  struct Node *next;
};

struct Node *create_node(int data) {
  struct Node *node = malloc(sizeof(struct Node));
  node->data = data;
  return node;
}

int main() {
  struct Node *n1 = create_node(1);
  struct Node *n2 = create_node(2);
  struct Node *n3 = create_node(3);
  struct Node *n4 = create_node(4);
  struct Node *head;
  head = n1;
  n1->next = n2;
  n2->prev = n1;
  n2->next = n3;
  n3->prev = n2;
  n3->next = n4;
  n4->prev = n3;

  return 0;
}

#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *next;
};

struct Node *head;

void count_nodes(struct Node *node);
void search_element(struct Node *node, int element);
void display_by_skipping_one(struct Node *node);
void display_reverse(struct Node *node);

int main() {
  struct Node *n1 = (struct Node *)malloc(sizeof(struct Node));
  struct Node *n2 = (struct Node *)malloc(sizeof(struct Node));
  struct Node *n3 = (struct Node *)malloc(sizeof(struct Node));

  head = n1;
  n1->data = 10;
  n1->next = n2;
  n2->data = 20;
  n2->next = n3;
  n3->data = 30;
  n3->next = NULL;

  display_reverse(head);
  printf("\n");
  count_nodes(head);
  search_element(head, 20);
  display_by_skipping_one(head);

  return 0;
}

void display_reverse(struct Node *node) {
  if (node == NULL) {
    return;
  } else {
    display_reverse(node->next);
    printf("%d, ", node->data);
  }
  return;
}

void count_nodes(struct Node *node) {
  int count = 0;
  while (node != NULL) {
    count++;
    node = node->next;
  }
  printf("Number of nodes are: %d\n", count);
}

void search_element(struct Node *node, int element) {
  int count = 0;
  while (node != NULL) {
    if (node->data == element) {
      printf("Element found at Node %d\n", count);
      return;
    }
    count++;
    node = node->next;
  }
  printf("Element not found\n");
  return;
}

void display_by_skipping_one(struct Node *node) {
  while (node != NULL) {
    printf("%d ", node->data);
    node = node->next;
    if (node == NULL) {
      return;
    } else {
      node = node->next;
    }
  }
}

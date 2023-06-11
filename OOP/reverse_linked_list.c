#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *next;
};

struct Node *head;

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

  struct Node *current = head;
  struct Node *prev = NULL, *next = NULL;

  while (current != NULL) {
    // Store next
    next = current->next;
    // Reverse current node's pointer
    current->next = prev;
    // Move pointers one position ahead.
    prev = current;
    current = next;
  }
  head = prev;

  struct Node *curr = head;

  while (curr != NULL) {
    printf("%d ", curr -> data);
    curr = curr -> next;
  }

    return 0;
}

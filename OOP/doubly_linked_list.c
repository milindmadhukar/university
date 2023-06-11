#include <stdio.h>
#include <stdlib.h>

struct Node {
  struct Node *prev;
  int data;
  struct Node *next;
};

struct Node *head, *tail;

int main() {
  struct Node *n1 = (struct Node *)malloc(sizeof(struct Node));
  struct Node *n2 = (struct Node *)malloc(sizeof(struct Node));
  struct Node *n3 = (struct Node *)malloc(sizeof(struct Node));

  head = n1;
  n1->prev = NULL;
  n1->data = 1;
  n1->next = n2;
  n2->prev = n1;
  n2->data = 69;
  n2->next = n3;
  n3->prev = n2;
  n3->data = 420;
  n3->next = NULL;
  tail = n3;
  
  struct Node *curr = head;
  while(curr != NULL) {
    printf("%d", curr -> data);
    curr = curr -> next;
  }



  return 0;
}

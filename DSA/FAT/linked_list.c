//Write a program to create the singly linked list and perform the following operations.
// a. Traverse
// b. Insertion of a new node at the beginning. (before first node)
// c. Insertion of a new node at the end of the list. (after last node)
// d. Insertion of a new node after a given node.
// e. Deletion of a beginning node. (first node)
// f. Deletion of a last node.
// g. Deletion after a given node.
// h. Traversing and printing the elements in reverse order.
// i. Traversing and printing alternate node elements. 

#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *next;
};

struct LinkedList {
  struct Node *head;
};

struct LinkedList *create_linked_list();
void traverse(struct LinkedList *linkedList);
void insert_first(struct LinkedList *linkedList, int value);
void insert_last(struct LinkedList *linkedList, int value);
void insert_pos(struct LinkedList *linkedList, int value, int pos);
int delete_first(struct LinkedList *linkedList);
int delete_last(struct LinkedList *linkedList);
int delete_pos(struct LinkedList *linkedList, int pos);
void print_reverse(struct LinkedList *linkedList);
void print_alternate(struct LinkedList *linkedList);

int main() {
  struct LinkedList *ll = create_linked_list();
  insert_first(ll, 10);
  insert_first(ll, 20);
  insert_last(ll, 30);
  insert_pos(ll, 40, 2);
  insert_pos(ll, 50, 3);
  traverse(ll);

  int e;
  e = delete_first(ll);
  printf("Element deleted is: %d\n", e);
  traverse(ll);
  e = delete_last(ll);
  printf("Element deleted is: %d\n", e);
  //

  e = delete_pos(ll, 2);
  printf("Element deleted is: %d\n", e);

  traverse(ll);

  print_reverse(ll);
  print_alternate(ll);

  return 0;
}

struct LinkedList *create_linked_list() {
  struct LinkedList *linkedList =
      (struct LinkedList *)malloc(sizeof(struct LinkedList));
  linkedList->head = NULL;
  return linkedList;
}

void traverse(struct LinkedList *linkedList) {
  struct Node *node = linkedList->head;
  while (node != NULL) {
    printf("%d->", node->data);
    node = node->next;
  }
  printf("\n");
}
void insert_first(struct LinkedList *linkedList, int value) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = value;

  if (linkedList->head == NULL) {
    linkedList->head = node;
    node->next = NULL;
  } else {
    node->next = linkedList->head;
    linkedList->head = node;
  }
}

void insert_last(struct LinkedList *linkedList, int value) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = value;
  node->next = NULL;
  if (linkedList->head == NULL) {
    linkedList->head = node;
  } else {
    struct Node *current = linkedList->head;
    while (current->next != NULL) {
      current = current->next;
    }
    current->next = node;
  }
}

int size(struct LinkedList *linkedList) {
  struct Node *node = linkedList->head;
  int count = 0;
  while (node != NULL) {
    count++;
    node = node->next;
  }
  return count;
}

void insert_pos(struct LinkedList *linkedList, int value, int pos) {
  if (pos == 1)
    insert_first(linkedList, value);
  else if (pos == size(linkedList))
    insert_last(linkedList, value);
  else {
    struct Node *current = linkedList->head;
    struct Node *previous = NULL;
    for (int i = 0; i < pos; i++) {
      previous = current;
      current = current->next;
    }

    struct Node *node = (struct Node *)malloc(sizeof(struct Node));
    node->data = value;

    previous->next = node;
    node->next = current;
  }
}

int delete_first(struct LinkedList *linkedList) {
  struct Node *node_to_remove = linkedList->head;
  if (linkedList->head == NULL) {
    printf("Nothing to remove");
    return -1;
  }

  int e = node_to_remove->data;

  linkedList->head = linkedList->head->next;
  free(node_to_remove);

  return e;
}

int delete_last(struct LinkedList *linkedList) {
  if (linkedList->head == NULL) {
    printf("Nothing to remove");
    return -1;
  }

  struct Node *current = linkedList->head;
  struct Node *previous = NULL;
  while (current->next != NULL) {
    previous = current;
    current = current->next;
  }

  int e = current->data;
  previous->next = NULL;
  free(current);

  return e;
}
int delete_pos(struct LinkedList *linkedList, int pos) {
  if (linkedList->head == NULL) {
    printf("Nothing to remove");
    return -1;
  }

  struct Node *current = linkedList->head;
  struct Node *previous = NULL;
  for (int i = 0; i < pos; i++) {
    previous = current;
    current = current->next;
  }

  previous->next = current->next;
  int e = current->data;
  free(current);

  return e;
}

void reverse(struct Node *node) {
  if (node == NULL) {
    return;
  } else {
    reverse(node->next);
    printf("%d, ", node->data);
  }
  return;
}

void print_reverse(struct LinkedList *linkedList) {
  struct Node *head = linkedList->head;
  reverse(head);
}

void print_alternate(struct LinkedList *linkedList) {
  struct Node *node = linkedList->head;
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

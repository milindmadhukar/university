// Implement Dijkstra’s algorithm for the given graph G

#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

struct Adjacent {
  struct Node *to;
  int weight;
};

struct Node {
  int data;
  struct Adjacent *adjacents[100];
  int visited;
  int distance;
};

struct Node *create_node(char data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->visited = false;
  for (int i = 0; i < 100; i++) {
    node->adjacents[i] = NULL;
    node->distance = INT_MAX;
  }
  return node;
}

void dijkstra(struct Node *start) {
  start->distance = 0;

  struct Node *current = start;

  while (current != NULL) {
    current->visited = true;

    for (int i = 0; i < 100; i++) {
      if (current->adjacents[i] != NULL) {
        struct Node *to = current->adjacents[i]->to;
        int weight = current->adjacents[i]->weight;

        if (to->distance > current->distance + weight) {
          to->distance = current->distance + weight;
        }
      }
    }

    int min = INT_MAX;
    struct Node *next = NULL;

    for (int i = 0; i < 100; i++) {
      if (current->adjacents[i] != NULL) {
        struct Node *to = current->adjacents[i]->to;
        int weight = current->adjacents[i]->weight;

        if (to->visited == false && to->distance < min) {
          min = to->distance;
          next = to;
        }
      }
    }

    current = next;
  }
}

int main() {

  struct Node *a = create_node('a');
  struct Node *b = create_node('b');
  struct Node *c = create_node('c');
  struct Node *d = create_node('d');
  struct Node *e = create_node('e');
  struct Node *f = create_node('f');

  struct Adjacent ab = {b, 3};
  struct Adjacent ad = {d, 2};

  a->adjacents[0] = &ab;
  a->adjacents[1] = &ad;

  struct Adjacent bc = {c, 5};

  b->adjacents[0] = &bc;

  struct Adjacent ce = {e, 4};

  c->adjacents[0] = &ce;

  struct Adjacent de = {e, 7};

  d->adjacents[0] = &de;

  struct Adjacent ec = {c, 2};
  struct Adjacent ef = {f, 5};

  e->adjacents[0] = &ec;
  e->adjacents[1] = &ef;

  struct Adjacent fe = {e, 3};

  f->adjacents[0] = &fe;

  dijkstra(a);

  printf("Distance from a to b: %d\n", b->distance);
  printf("Distance from a to c: %d\n", c->distance);
  printf("Distance from a to d: %d\n", d->distance);
  printf("Distance from a to e: %d\n", e->distance);
  printf("Distance from a to f: %d\n", f->distance);

  return 0;
}

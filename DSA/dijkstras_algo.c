#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

struct Adjacent {
  struct Node *to;
  int weight;
};

struct Node {
  char data;
  struct Adjacent *adjacents[10];
  bool visited;
  int distance;
};

struct Node *create_node(char data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->visited = false;
  for (int i = 0; i < 10; i++) {
    node->adjacents[i] = NULL;
    node->distance = INT_MAX;
  }
  return node;
}

void dijkstra(struct Node *start) {
  // Implement the algorithm and store each nodes distance from the start node and print in

  start->distance = 0;
  struct Node *current = start;

  while (current != NULL) {
    current->visited = true;
    for (int i = 0; i < 10; i++) {
      if (current->adjacents[i] != NULL) {
        if (current->adjacents[i]->to->visited == false) {
          if (current->distance + current->adjacents[i]->weight <
              current->adjacents[i]->to->distance) {
            current->adjacents[i]->to->distance =
                current->distance + current->adjacents[i]->weight;
          }
        }
      }
    }
    int min = INT_MAX;
    for (int i = 0; i < 10; i++) {
      if (current->adjacents[i] != NULL) {
        if (current->adjacents[i]->to->visited == false) {
          if (current->adjacents[i]->to->distance < min) {
            min = current->adjacents[i]->to->distance;
            current = current->adjacents[i]->to;
          }
        }
      }
    }
    if (min == INT_MAX) {
      current = NULL;
    }
  }
}


int main() {
  struct Node *a = create_node('A');
  struct Node *b = create_node('B');
  struct Node *c = create_node('C');
  struct Node *d = create_node('D');
  struct Node *e = create_node('E');
  struct Node *f = create_node('F');
  struct Node *g = create_node('G');

  // struct Adjacent ab = {b, 2};
  // struct Adjacent ad = {d, 3};
  // struct Adjacent ba = {a, 2};
  // struct Adjacent bd = {d, 6};
  // struct Adjacent bc = {c, 8};
  // struct Adjacent be = {e, 4};
  // struct Adjacent cb = {b, 8};
  // struct Adjacent cd = {d, 5};
  // struct Adjacent ce = {e, 3};
  // struct Adjacent cf = {f, 2};
  // struct Adjacent da = {a, 3};
  // struct Adjacent db = {b, 6};
  // struct Adjacent dc = {c, 5};
  // struct Adjacent de = {e, 4};
  // struct Adjacent ed = {d, 4};
  // struct Adjacent eb = {b, 4};
  // struct Adjacent ec = {c, 3};
  // struct Adjacent ef = {f, 7};
  // struct Adjacent fc = {c, 2};
  // struct Adjacent fe = {e, 7};
  // struct Adjacent fg = {g, 5};
  // struct Adjacent gf = {f, 5};
  struct Adjacent af = {f, 10};
  struct Adjacent ab = {b, 28};
  struct Adjacent bg = {g, 14};
  struct Adjacent bc = {c, 16};
  struct Adjacent cd = {d, 12};
  struct Adjacent de = {e, 22};
  struct Adjacent eg = {g, 24};
  struct Adjacent ef = {f, 25};
  struct Adjacent gd = {d, 18};



  a->adjacents[0] = &af;
  a->adjacents[1] = &ab;

  b->adjacents[0] = &bg;
  b->adjacents[1] = &bc;
  b->adjacents[2] = &ab;

  c->adjacents[0] = &cd;
  c->adjacents[1] = &bc;

  d->adjacents[0] = &de;
  d->adjacents[1] = &cd;
  d->adjacents[2] = &gd;

  e->adjacents[0] = &eg;
  e->adjacents[1] = &de;

  f->adjacents[0] = &ef;
  f->adjacents[1] = &af;

  g->adjacents[0] = &gd;
  g->adjacents[1] = &bg;
  g->adjacents[2] = &eg;

  dijkstra(a);

  // Print distances from the start node to each node
  
  printf("%s : %d", "A", a->distance);
  printf("\n");
  printf("%s : %d", "B", b->distance);
  printf("\n");
  printf("%s : %d", "C", c->distance);
  printf("\n");
  printf("%s : %d", "D", d->distance);
  printf("\n");
  printf("%s : %d", "E", e->distance);
  printf("\n");
  printf("%s : %d", "F", f->distance);
  printf("\n");
  printf("%s : %d", "G", g->distance);
  printf("\n");

  return 0;
}

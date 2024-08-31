// Implement Breadth First Traversal algorithm for a graph data structure.

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *adjacent[100];
};

struct Node *create_node(int data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  return node;
};

void breadth_first_search(struct Node *start) {
  // Initialize the visited array to 0 for all nodes
  int visited[100] = {0};

  // Create a queue for BFS
  struct Node *visited_queue[100];
  int front = -1;
  int rear = -1;

  // Mark the start node as visited and enqueue it
  visited[start->data] = 1;
  visited_queue[++rear] = start;

  // Loop until the queue is empty
  while (front != rear) {
    // Dequeue a node from the queue and print its value
    struct Node *current_node = visited_queue[++front];
    printf("%d ", current_node->data);

    // Enqueue all adjacent nodes of the dequeued node that have not been
    // visited
    for (int i = 0; i < 100; i++) {
      if (current_node->adjacent[i] != NULL) {
        struct Node *adjacent_node = current_node->adjacent[i];
        if (visited[adjacent_node->data] == 0) {
          visited[adjacent_node->data] = 1;
          visited_queue[++rear] = adjacent_node;
        }
      }
    }
  }
}

int main() {
  struct Node *a = create_node(0);
  struct Node *b = create_node(1);
  struct Node *c = create_node(2);
  struct Node *d = create_node(3);
  struct Node *e = create_node(4);
  struct Node *f = create_node(5);
  struct Node *g = create_node(6);
  struct Node *h = create_node(7);
  struct Node *i = create_node(8);

  // a has adjacent as b,c
  // b has adjacent as a,d,e
  // c has adjacent as a,e,f
  // d has adjacent as b,g
  // e has adjacent as b,c,g,h
  // f has adjacent as c,h
  // g has adjacent as d,e,i
  // h has adjacent as e,f,i
  // i has adjacent as h,g

  // Add adjacent nodes for each node
  a->adjacent[0] = b;
  a->adjacent[1] = c;
  b->adjacent[0] = a;
  b->adjacent[1] = d;
  b->adjacent[2] = e;
  c->adjacent[0] = a;
  c->adjacent[1] = e;
  c->adjacent[2] = f;
  d->adjacent[0] = b;
  d->adjacent[1] = g;
  e->adjacent[0] = b;
  e->adjacent[1] = c;
  e->adjacent[2] = g;
  e->adjacent[3] = h;
  f->adjacent[0] = c;
  f->adjacent[1] = h;
  g->adjacent[0] = d;
  g->adjacent[1] = e;
  g->adjacent[2] = i;
  h->adjacent[0] = e;
  h->adjacent[1] = f;
  h->adjacent[2] = i;
  i->adjacent[0] = g;
  i->adjacent[1] = h;

  // Perform BFS starting from node a
  printf("BFS traversal: ");
  breadth_first_search(d);

  return 0;
}

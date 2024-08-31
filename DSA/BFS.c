#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *adjacent[100];
};

struct Node *create_node(int data) {
  struct Node *node = (struct Node*)malloc(sizeof(struct Node));
  node->data = data;
  return node;
}

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

  struct Node *s = create_node(0); // s-a-c-b-d-t
  struct Node *a = create_node(1);
  struct Node *b = create_node(2);
  struct Node *c = create_node(3);
  struct Node *d = create_node(4);
  struct Node *t = create_node(5);

  // s has adjacent as a,c
  // a has adjacent as b, c, d
  // b has adjacent as t
  // c has adjacent as d
  // d has adjacent as b, t

  // Add adjacent nodes for each node
  s->adjacent[0] = a;
  s->adjacent[1] = c;

  a->adjacent[0] = b;
  a->adjacent[1] = c;
  a->adjacent[2] = d;

  b->adjacent[0] = t;

  c->adjacent[0] = d;

  d->adjacent[0] = b;
  d->adjacent[1] = t;

  // Perform BFS starting from node a
  printf("BFS traversal: ");
  breadth_first_search(s);

  return 0;
}

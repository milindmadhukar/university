// Implement Iterative Deepening DFS algorithm for a graph data structure with
// weighted egdes

#include <stdio.h>
#include <stdlib.h>

// Make node and edge structures where a node can have multiple edges

struct edge {
  char dest;
  int weight;

  struct edge *next;
} edge;

struct node {
  char data;
  struct edge *edges;
};

// Make a graph structure where a graph can have multiple nodes

struct graph {
  int numNodes;
  struct node *nodes;
};

// Function to create a new nodes

struct node *newNode(char data) {
  struct node *newNode = (struct node *)malloc(sizeof(struct node));
  newNode->data = data;
  newNode->edges = NULL;
  return newNode;
}

// Function to create a new edge

struct edge *newEdge(char dest, int weight) {
  struct edge *newEdge = (struct edge *)malloc(sizeof(struct edge));
  newEdge->dest = dest;
  newEdge->weight = weight;
  newEdge->next = NULL;
  return newEdge;
}

// Function to create a new Graph

struct graph *newGraph(int numNodes) {
  struct graph *graph = (struct graph *)malloc(sizeof(struct graph));
  graph->numNodes = numNodes;
  graph->nodes = (struct node *)malloc(numNodes * sizeof(struct node));
  for (int i = 0; i < numNodes; i++) {
    graph->nodes[i].data = 'A' + i;
    graph->nodes[i].edges = NULL;
  }
  return graph;
}

// Function to add an edge to the Graph

void addEdge(struct graph *graph, char src, char dest, int weight) {
  int srcIndex = src - 'A';
  int destIndex = dest - 'A';
  struct edge *addedEdge = newEdge(dest, weight);
  addedEdge->next = graph->nodes[srcIndex].edges;
  graph->nodes[srcIndex].edges = addedEdge;
}

// Function to print the graph

void printGraph(struct graph *graph) {
  for (int i = 0; i < graph->numNodes; i++) {
    struct node *curr = &graph->nodes[i];
    printf("%c -> ", curr->data);
    struct edge *edge = curr->edges;
    while (edge) {
      printf("%c(%d) ", edge->dest, edge->weight);
      edge = edge->next;
    }
    printf("\n");
  }
}

// Function to perform Depth First Search

int dfs(struct graph *graph, char src, char dest, int depth) {
  if (depth < 0) {
    return 0;
  }

  int srcIndex = src - 'A';
  struct node *curr = &graph->nodes[srcIndex];
  printf("%c ", curr->data);

  if (curr->data == dest) {
    printf("\n");
    return 1;
  }

  struct edge *edge = curr->edges;
  while (edge) {
    if (dfs(graph, edge->dest, dest, depth - 1)) {
      return 1;
    }
    edge = edge->next;
  }

  return 0;
}

int main() {
  struct graph *graph = newGraph(8);
  addEdge(graph, 'S', 'A', 5);
  addEdge(graph, 'S', 'B', 9);
  addEdge(graph, 'S', 'D', 6);

  addEdge(graph, 'A', 'B', 3);
  addEdge(graph, 'A', 'G', 9);

  addEdge(graph, 'B', 'A', 2);
  addEdge(graph, 'B', 'C', 1);

  addEdge(graph, 'C', 'S', 6);
  addEdge(graph, 'C', 'F', 7);
  addEdge(graph, 'C', 'H', 5);

  addEdge(graph, 'D', 'C', 2);
  addEdge(graph, 'D', 'E', 2);

  addEdge(graph, 'E', 'I', 7);

  addEdge(graph, 'F', 'I', 8);
  addEdge(graph, 'F', 'D', 2);

  // All edges added

  printGraph(graph);

  // Graph printed

  // Perform Iterative Deepening DFS

  for (int i = 0; i < 10; i++) {
    printf("Depth %d: ", i);
    dfs(graph, 'S', 'G', i);
  }
}

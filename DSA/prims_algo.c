#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

struct Adjacent {
  struct Node *to;
  int weight;
};

struct Node {
  int data;
  struct Adjacent *adjacents[4];
  bool visited;
};

struct Node *create_node(int data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->visited = false;
  for (int i = 0; i < 4; i++) {
    node->adjacents[i] = NULL;
  }
  return node;
}

void prim(struct Node *startNode) {
  startNode->visited = true;
  int totalWeight = 0;

  // Traverse until all nodes are visited
  while (true) {
    struct Node *minNode = NULL;
    struct Adjacent *minAdjacent = NULL;
    int minWeight = INT_MAX;

    // Find the minimum weight adjacent edge
    for (int i = 0; i < 4; i++) {
      struct Adjacent *adjacent = startNode->adjacents[i];
      if (adjacent != NULL && !adjacent->to->visited && adjacent->weight < minWeight) {
        minNode = startNode;
        minAdjacent = adjacent;
        minWeight = adjacent->weight;
      }
    }

    if (minNode == NULL) {
      // No more adjacent nodes to visit
      break;
    }

    struct Node *nextNode = minAdjacent->to;
    nextNode->visited = true;
    totalWeight += minWeight;

    printf("Node: %d - %d\tWeight: %d\n", minNode->data, nextNode->data, minWeight);

    startNode = nextNode;
  }

  printf("Total Weight: %d\n", totalWeight);
}

int main() {
  // Create 5 nodes
  struct Node *nodes[5];
  for (int i = 0; i < 5; i++) {
    nodes[i] = create_node(i);
  }

  // Connect nodes
  nodes[0]->adjacents[0] = &(struct Adjacent){nodes[1], 10};
  nodes[0]->adjacents[1] = &(struct Adjacent){nodes[2], 6};

  nodes[1]->adjacents[0] = &(struct Adjacent){nodes[0], 10};
  nodes[1]->adjacents[1] = &(struct Adjacent){nodes[2], 5};
  nodes[1]->adjacents[2] = &(struct Adjacent){nodes[3], 15};
  nodes[1]->adjacents[3] = &(struct Adjacent){nodes[4], 2};

  nodes[2]->adjacents[0] = &(struct Adjacent){nodes[0], 6};
  nodes[2]->adjacents[1] = &(struct Adjacent){nodes[1], 5};

  nodes[3]->adjacents[0] = &(struct Adjacent){nodes[1], 15};

  nodes[4]->adjacents[0] = &(struct Adjacent){nodes[1], 2};

  // Start Prim's algorithm from the first node
  prim(nodes[0]);

  return 0;
}


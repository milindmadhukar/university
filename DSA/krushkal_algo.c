#include <stdio.h>
#include <stdlib.h>

struct Node {
  int data;
  struct Node *parent;
  int rank;
};

struct Edge {
  struct Node *src;
  struct Node *dest;
  int weight;
};

struct Node *create_node(int data) {
  struct Node *node = (struct Node *)malloc(sizeof(struct Node));
  node->data = data;
  node->parent = node;
  node->rank = 0;
  return node;
}

struct Edge *create_edge(struct Node *src, struct Node *dest, int weight) {
  struct Edge *edge = (struct Edge *)malloc(sizeof(struct Edge));
  edge->src = src;
  edge->dest = dest;
  edge->weight = weight;
  return edge;
}

struct Node *find(struct Node *node) {
  if (node->parent != node) {
    node->parent = find(node->parent);
  }
  return node->parent;
}

void union_nodes(struct Node *x, struct Node *y) {
  struct Node *x_root = find(x);
  struct Node *y_root = find(y);

  if (x_root != y_root) {
    if (x_root->rank < y_root->rank) {
      x_root->parent = y_root;
    } else if (x_root->rank > y_root->rank) {
      y_root->parent = x_root;
    } else {
      y_root->parent = x_root;
      x_root->rank++;
    }
  }
}

// Implement the krushkal's algorithm and find out indivisual weights of the
// edges
void kruskal(struct Node *nodes[], struct Edge *edges[], int num_nodes,
             int num_edges) {
  // Sort the edges in ascending order of their weights
  for (int i = 0; i < num_edges; i++) {
    for (int j = 0; j < num_edges - i - 1; j++) {
      if (edges[j]->weight > edges[j + 1]->weight) {
        struct Edge *temp = edges[j];
        edges[j] = edges[j + 1];
        edges[j + 1] = temp;
      }
    }
  }

  // Apply Krushkal's algorithm
  struct Edge *mst[num_nodes - 1];
  int mst_index = 0;
  for (int i = 0; i < num_edges; i++) {
    struct Node *src_root = find(edges[i]->src);
    struct Node *dest_root = find(edges[i]->dest);

    if (src_root != dest_root) {
      mst[mst_index++] = edges[i];
      union_nodes(src_root, dest_root);
    }
  }

  // Print the edges of the minimum spanning tree
  printf("Minimum spanning tree:\n");
  for (int i = 0; i < num_nodes - 1; i++) {
    printf("%d -> %d\n", mst[i]->src->data, mst[i]->dest->data);
  }
}

int main() {
  // Create 5 nodes
  struct Node *nodes[5];
  for (int i = 0; i < 5; i++) {
    nodes[i] = create_node(i);
  }

  // Create edges
  struct Edge *edges[7];
  edges[0] = create_edge(nodes[0], nodes[1], 10);
  edges[1] = create_edge(nodes[0], nodes[2], 6);
  edges[2] = create_edge(nodes[1], nodes[2], 5);
  edges[3] = create_edge(nodes[1], nodes[3], 15);
  edges[4] = create_edge(nodes[1], nodes[4], 2);
  edges[5] = create_edge(nodes[2], nodes[3], 4);
  edges[6] = create_edge(nodes[3], nodes[4], 3);

  // Apply Kruskal's algorithm
  kruskal(nodes, edges, 5, 7);

  // Cleanup - Free allocated memory
  for (int i = 0; i < 5; i++) {
    free(nodes[i]);
  }
  for (int i = 0; i < 7; i++) {
    free(edges[i]);
  }

  return 0;
}

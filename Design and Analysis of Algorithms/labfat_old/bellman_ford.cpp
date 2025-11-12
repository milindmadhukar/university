#include <climits>
#include <iostream>
#define V 5
#define E 10

void BellmanFord(int edges[V][V], int src) {
  int dist[V];
  for (int i = 0; i < V; i++)
    dist[i] = INT_MAX;

  dist[src] = 0;

  for (int count = 1; count <= V - 1; count++) {
    for (int u = 0; u < V; u++) {
      for (int v = 0; v < V; v++) {
        if (edges[u][v] == 0)
          continue;
        int weight = edges[u][v];

        if (dist[u] != INT_MAX && dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
        }
      }
    }
  }

  for (int u = 0; u < V; u++) {
    for (int v = 0; v < V; v++) {
      if (edges[u][v] == 0)
        continue;
      int weight = edges[u][v];

      if (dist[u] != INT_MAX && dist[u] + weight < dist[v]) {
        std::cout << "Negative cycle found" << std::endl;
        return;
      }
    }
  }

  // Print
  std::cout << "Vertex\tDistance from Vertex" << std::endl;
  for (int i = 0; i < V; i++) {
    std::cout << i << "\t\t" << dist[i] << std::endl;
  }

  return;
}

int main() { int edges[V][V] = {
      {0, 6, 0, 7, 0},  {0, 0, 5, 8, -4}, {0, -2, 0, 0, 0},
      {0, 0, -3, 0, 9}, {2, 0, 7, 0, 0},
  };

  BellmanFord(edges, 0);
}


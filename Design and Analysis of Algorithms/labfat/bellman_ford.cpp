#include <climits>
#include <iostream>

struct Edge {
  int src, dest, weight;
};

struct Graph {
  int V, E;

  Edge *edges;
  Graph(int V, int E) {
    this->V = V;
    this->E = E;

    edges = new Edge[E];
  }
};

void BellmanFord(Graph *graph, int src) {
  int dist[graph->V];

  for (int i = 0; i < graph->V; i++) {
    dist[i] = INT_MAX;
  }
  dist[src] = 0;

  for (int count = 0; count < graph->V - 1; count++) {
    for (int i = 0; i < graph->E; i++) {
      int u = graph->edges[i].src;
      int v = graph->edges[i].dest;
      int weight = graph->edges[i].weight;

      if (dist[u] != INT_MAX && dist[u] + weight < dist[v]) {
        dist[v] = dist[u] + weight;
      }
    }
  }

  for (int i = 0; i < graph->E; i++) {
    int u = graph->edges[i].src;
    int v = graph->edges[i].dest;
    int weight = graph->edges[i].weight;
    if (dist[u] != INT_MAX && dist[u] + weight < dist[v]) {
      std::cout << "Graph contains negative weight cycle" << std::endl;
      return;
    }
  }

  std::cout << "Vertex\tDistance from source" << std::endl;
  for (int i = 0; i < graph->V; ++i)
    std::cout << i << "\t\t" << dist[i] << std::endl;
}

int main() {
  int V = 5;
  int E = 8;
  Graph *graph = new Graph(V, E);

  // add edge 0-1 (or A-B in above figure)
  graph->edges[0].src = 0;
  graph->edges[0].dest = 1;
  graph->edges[0].weight = -1;

  // add edge 0-2 (or A-C in above figure)
  graph->edges[1].src = 0;
  graph->edges[1].dest = 2;
  graph->edges[1].weight = 4;

  // add edge 1-2 (or B-C in above figure)
  graph->edges[2].src = 1;
  graph->edges[2].dest = 2;
  graph->edges[2].weight = 3;

  // add edge 1-3 (or B-D in above figure)
  graph->edges[3].src = 1;
  graph->edges[3].dest = 3;
  graph->edges[3].weight = 2;

  // add edge 1-4 (or B-E in above figure)
  graph->edges[4].src = 1;
  graph->edges[4].dest = 4;
  graph->edges[4].weight = 2;

  // add edge 3-2 (or D-C in above figure)
  graph->edges[5].src = 3;
  graph->edges[5].dest = 2;
  graph->edges[5].weight = 5;

  // add edge 3-1 (or D-B in above figure)
  graph->edges[6].src = 3;
  graph->edges[6].dest = 1;
  graph->edges[6].weight = 1;

  // add edge 4-3 (or E-D in above figure)
  graph->edges[7].src = 4;
  graph->edges[7].dest = 3;
  graph->edges[7].weight = -3;

  // Function call
  BellmanFord(graph, 0);

  return 0;
}

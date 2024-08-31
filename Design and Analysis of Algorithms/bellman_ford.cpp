#include <bits/stdc++.h>
using namespace std;

struct Edge {
  int s, d, w;
};

struct Graph {
  int V, E;
  struct Edge *edge;
};

struct Graph *createGraph(int V, int E) {
  struct Graph *g = new Graph;
  g->V = V;
  g->E = E;
  g->edge = new Edge[E];
  return g;
}

void printArr(int d[], int n) {
  for (int i = 0; i < n; ++i)
    printf("%d \t\t %d\n", i, d[i]);
}

void BellmanFord(struct Graph *g, int src) {
  int V = g->V;
  int E = g->E;
  int d[V];

  for (int i = 0; i < V; i++)
    d[i] = INT_MAX;
  d[src] = 0;

  for (int i = 1; i <= V - 1; i++) {
    for (int j = 0; j < E; j++) {
      int u = g->edge[j].s;
      int v = g->edge[j].d;
      int w = g->edge[j].w;
      if (d[u] != INT_MAX && d[u] + w < d[v])
        d[v] = d[u] + w;
    }
  }

  for (int i = 0; i < E; i++) {
    int u = g->edge[i].s;
    int v = g->edge[i].d;
    int w = g->edge[i].w;
    if (d[u] != INT_MAX && d[u] + w < d[v]) {
      printf("Graph contains negative weight cycle");
      return;
    }
  }

  printArr(d, 5);
  return;
}

int main() {
  int V = 6;  // Number of vertices including source and sink
  int E = 10; // Number of edges
  struct Graph *g = createGraph(V, E);

  g->edge[0].s = 0;
  g->edge[0].d = 1;
  g->edge[0].w = 6;
  g->edge[1].s = 0;
  g->edge[1].d = 3;
  g->edge[1].w = 7;
  g->edge[2].s = 1;
  g->edge[2].d = 2;
  g->edge[2].w = 5;
  g->edge[3].s = 1;
  g->edge[3].d = 3;
  g->edge[3].w = 8;
  g->edge[4].s = 1;
  g->edge[4].d = 4;
  g->edge[4].w = -4;
  g->edge[5].s = 2;
  g->edge[5].d = 1;
  g->edge[5].w = -2;
  g->edge[6].s = 3;
  g->edge[6].d = 2;
  g->edge[6].w = -3;
  g->edge[7].s = 3;
  g->edge[7].d = 4;
  g->edge[7].w = 9;
  g->edge[8].s = 4;
  g->edge[8].d = 2;
  g->edge[8].w = 7;
  g->edge[9].s = 4;
  g->edge[9].d = 0;
  g->edge[9].w = 2;

  int s = 0;
  int t = 5;

  BellmanFord(g, s);

  return 0;
}

#include <iostream>
#include <limits.h>
#include <queue>
#include <string.h>
using namespace std;

#define V 6

bool bfs(int rGraph[V][V], int src, int sink, int parent[]) {
  bool visited[V];
  memset(visited, 0, sizeof(visited));
  queue<int> q;
  q.push(src);
  visited[src] = true;
  parent[src] = -1;

  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int v = 0; v < V; v++) {
      if (visited[v] == false && rGraph[u][v] > 0) {
        if (v == sink) {
          parent[v] = u;
          return true;
        }
        q.push(v);
        parent[v] = u;
        visited[v] = true;
      }
    }
  }
  return false;
}

int fordFulkerson(int graph[V][V], int src, int sink) {
  int u, v;
  int rGraph[V][V];
  for (u = 0; u < V; u++)
    for (v = 0; v < V; v++)
      rGraph[u][v] = graph[u][v];

  int parent[V];
  int maxFlow = 0;

  while (bfs(rGraph, src, sink, parent)) {
    int pathFlow = INT_MAX;
    for (v = sink; v != src; v = parent[v]) {
      u = parent[v];
      pathFlow = min(pathFlow, rGraph[u][v]);
    }
    for (v = sink; v != src; v = parent[v]) {
      u = parent[v];
      rGraph[u][v] -= pathFlow;
      rGraph[v][u] += pathFlow;
    }
    maxFlow += pathFlow;
  }
  return maxFlow;
}

int main() {
  int graph[V][V] = {{0, 16, 13, 0, 0, 0}, {0, 0, 0, 12, 0, 0},
                     {0, 4, 0, 0, 14, 0},  {0, 0, 9, 0, 0, 20},
                     {0, 0, 0, 7, 0, 4},   {0, 0, 0, 0, 0, 0}};

  cout << "Max flow is: " << fordFulkerson(graph, 0, 5);

  return 0;
}

#include <algorithm>
#include <climits>
#include <cstring>
#include <iostream>
#include <queue>
#define V 6

bool bfs(int graph[V][V], int s, int t, int parent[V]) {

  bool visited[V];

  for (int i = 0; i < V; i++) {
    visited[i] = false;
  }

  std::queue<int> q;
  q.push(s);
  visited[s] = true;
  parent[s] = -1;

  while (!q.empty()) {
    int u = q.front();
    q.pop();

    for (int v = 0; v < V; v++) {
      if (!visited[v] && graph[u][v] > 0) {

        if (v == t) {
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

int fordFulkerson(int graph[V][V], int s, int t) {

  // Creating a residual capacity graph
  int u, v;

  int rGraph[V][V];

  for (u = 0; u < V; u++)
    for (v = 0; v < V; v++)
      rGraph[u][v] = graph[u][v];

  int parent[V];

  int max_flow = 0;

  while (bfs(rGraph, s, t, parent)) {

    int path_flow = INT_MAX;
    int v = t;
    for (v = t; v != s; v = parent[v]) {
      u = parent[v];
      path_flow = std::min(path_flow, rGraph[u][v]);
    }

    for (v = t; v != s; v = parent[v]) {
      u = parent[v];
      rGraph[u][v] -= path_flow;
      rGraph[v][u] += path_flow;
    }

    max_flow += path_flow;
  }

  return max_flow;
}

// S A B C D T
int main() {
  int graph[V][V] = {{0, 10, 0, 10, 0, 0}, {0, 0, 4, 2, 8, 0},
                     {0, 0, 0, 0, 0, 10},  {0, 0, 0, 0, 9, 0},
                     {0, 0, 6, 0, 0, 10},  {0, 0, 0, 0, 0, 0}};

  int s = 0, t = 5;

  std::cout << "The maximum possible flow is " << fordFulkerson(graph, 0, 5);
}

#include <algorithm>
#include <climits>
#include <iostream>
#include <queue>
#include <stack>
#include <vector>
#define V 7
#define E 12

void printPath(int parent[V], int source, int sink) {
  std::stack<int> s;
  int v = sink;
  s.push(v);
  do {
    v = parent[v];
    s.push(v);
  } while (v != source);

  std::cout << "The augmenting path is: ";

  while (!s.empty()) {
    std::cout << s.top() << " -> ";
    s.pop();
  }

  std::cout << std::endl;
}

bool bfs(int graph[V][V], int source, int sink, int *parent) {
  std::queue<int> q;

  bool visited[V];
  for (int i = 0; i < V; i++) {
    visited[i] = false;
  }

  q.push(source);
  visited[source] = true;
  parent[source] = -1;

  while (!q.empty()) {
    int u = q.front();
    q.pop();

    for (int v = 0; v < V; v++) {
      if (!visited[v] && graph[u][v] > 0) {
        q.push(v);
        parent[v] = u;
        visited[v] = true;

        if (v == sink)
          return true;
      }
    }
  }

  return false;
}

int FordFulkerson(int graph[V][V], int source, int sink) {
  int max_flow = 0;

  int parent[V];
  while (bfs(graph, source, sink, parent)) {
    int path_flow = INT_MAX;

    printPath(parent, source, sink);

    for (int v = sink; v != source; v = parent[v]) {
      int u = parent[v];
      path_flow = std::min(graph[u][v], path_flow);
    }

    max_flow += path_flow;

    for (int v = sink; v != source; v = parent[v]) {
      int u = parent[v];
      graph[u][v] -= path_flow;
      graph[v][u] += path_flow;
    }
  }

  return max_flow;
}

int main() {

  int graph[V][V] = {
      {0, 7, 0, 0, 10, 0, 0}, {0, 0, 5, 0, 1, 3, 0}, {0, 0, 0, 2, 0, 0, 10},
      {0, 0, 0, 0, 0, 0, 4},  {0, 0, 0, 7, 0, 2, 0}, {0, 0, 3, 2, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0},
  };

  int flow = FordFulkerson(graph, 0, 6);
  std::cout << "Max flow is: " << flow << std::endl;

  return 0;
}


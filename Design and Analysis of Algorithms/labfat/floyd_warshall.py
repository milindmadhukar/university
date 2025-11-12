def floyd_warshall(graph, num_vertices):
    dist = [[float('inf')] * num_vertices for _ in range(num_vertices)]
    
    for i in range(num_vertices):
        for j in range(num_vertices):
            if i == j:
                dist[i][j] = 0
            elif graph[i][j] != -1:  # -1 means no edge
                dist[i][j] = graph[i][j]
    
    # Floyd-Warshall algorithm
    for k in range(num_vertices):
        for i in range(num_vertices):
            for j in range(num_vertices):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    
    # Check for negative cycles
    for i in range(num_vertices):
        if dist[i][i] < 0:
            print("Negative cycle detected")
            return None
    
    print("Shortest distances between all pairs of vertices:")
    print("\nFrom\\To", end="")
    for j in range(num_vertices):
        print(f"\t{j}", end="")
    print()
    
    for i in range(num_vertices):
        print(f"{i}", end="")
        for j in range(num_vertices):
            if dist[i][j] == float('inf'):
                print("\tINF", end="")
            else:
                print(f"\t{dist[i][j]}", end="")
        print()
    
    return dist


graph = [
    [0, 4, -1, 5, -1],
    [-1, 0, 1, -1, 6],
    [2, -1, 0, 3, -1],
    [-1, -1, 1, 0, 2],
    [1, -1, -1, 4, 0]
]

num_vertices = 5

floyd_warshall(graph, num_vertices)

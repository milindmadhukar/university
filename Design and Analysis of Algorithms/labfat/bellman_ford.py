def bellman_ford(edges, num_vertices, src):
    dist = [float('inf')] * num_vertices
    dist[src] = 0
    
    for _ in range(num_vertices - 1):
        for u, v, weight in edges:
            if dist[u] != float('inf') and dist[u] + weight < dist[v]:
                dist[v] = dist[u] + weight
    
    # Check for negative cycles
    for u, v, weight in edges:
        if dist[u] != float('inf') and dist[u] + weight < dist[v]:
            print("Negative cycle found")
            return None
    
    # Print results
    print("Vertex\tDistance from Source")
    for i in range(num_vertices):
        print(f"{i}\t\t{dist[i]}")
    
    return dist


# Define edges as list of (source, destination, weight)
edges = [
    (0, 1, 6),
    (0, 3, 7),
    (1, 2, 5),
    (1, 3, 8),
    (1, 4, -4),
    (2, 1, -2),
    (3, 2, -3),
    (3, 4, 9),
    (4, 0, 2),
    (4, 2, 7)
]

num_vertices = 5
source = 0

bellman_ford(edges, num_vertices, source)

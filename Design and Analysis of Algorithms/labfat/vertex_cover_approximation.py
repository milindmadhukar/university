from collections import defaultdict

def approx_vertex_cover(graph):
    cover = set()
    
    # We need a mutable set of all unique edges.
    # Store edges as tuples (u, v) where u < v to avoid duplicates.
    edges_to_process = set()
    for u, neighbors in graph.items():
        for v in neighbors:
            if u < v:
                edges_to_process.add((u, v))

    # Loop while there are still edges to cover
    while edges_to_process:
        # 1. Pick an arbitrary edge (u, v)
        u, v = edges_to_process.pop()
        
        # 2. Add both endpoints to the cover
        cover.add(u)
        cover.add(v)
        
        # 3. Remove all edges incident to either u or v
        # We build a set of edges to remove and then update the main set
        edges_to_remove = set()
        for (a, b) in edges_to_process:
            if a == u or a == v or b == u or b == v:
                edges_to_remove.add((a, b))
        
        edges_to_process.difference_update(edges_to_remove)
            
    return cover

# --- Example Usage ---

def build_graph(edges):
    """Helper function to build an adjacency list from an edge list."""
    graph = defaultdict(set)
    for u, v in edges:
        graph[u].add(v)
        graph[v].add(u)
    return graph

# Define the graph using a list of edges
edge_list = [
    ('a', 'b'),
    ('b', 'c'),
    ('c', 'd'),
    ('c', 'e'),
    ('d', 'e'),
    ('e', 'a')
]

# Build the adjacency list representation
graph = build_graph(edge_list)

# Run the approximation algorithm
cover = approx_vertex_cover(graph)

print(f"Graph: {dict(graph)}")
print(f"Approximate Vertex Cover: {cover}")
print(f"Cover Size: {len(cover)}")

# Example 2
edge_list_2 = [
    (1, 2), (1, 6), (2, 3), (2, 4),
    (2, 5), (3, 4), (4, 5), (5, 6)
]
graph_2 = build_graph(edge_list_2)
cover_2 = approx_vertex_cover(graph_2)
print(f"\nGraph 2 Cover: {cover_2}")
print(f"Cover Size: {len(cover_2)}")

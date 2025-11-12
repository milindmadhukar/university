def nearest_neighbor_tsp_matrix(cost_matrix):
    num_cities = len(cost_matrix)
    if num_cities == 0:
        return [], 0

    # Start at city 0
    start_city = 0
    tour = [start_city]
    unvisited = set(range(num_cities))
    unvisited.remove(start_city)
    
    current_city = start_city
    total_cost = 0

    while unvisited:
        nearest_city = -1
        min_cost = float('inf')

        # Find the closest unvisited city from the current city
        for city in unvisited:
            cost = cost_matrix[current_city][city]
            if cost < min_cost:
                min_cost = cost
                nearest_city = city
        
        # Move to the nearest city
        tour.append(nearest_city)
        unvisited.remove(nearest_city)
        total_cost += min_cost
        current_city = nearest_city

    # Add the cost from the last city back to the start
    total_cost += cost_matrix[current_city][start_city]
    
    return tour, total_cost

inf = float('inf')

matrix = [
#   0    1    2    3    4    5
    [inf, 10,  8,   9,  7,  15],  # 0
    [10, inf, 10,  5,  6,  12],  # 1
    [8,  10, inf,  8,  9,  10],  # 2
    [9,   5,  8,  inf,  6,  11],  # 3
    [7,   6,  9,   6,  inf, 13],  # 4
    [15, 12, 10,  11, 13, inf]   # 5
]

tour_indices, tour_cost = nearest_neighbor_tsp_matrix(matrix)

print(f"Approximate Tour (by index): {tour_indices}")
print(f"Total Tour Cost: {tour_cost}")

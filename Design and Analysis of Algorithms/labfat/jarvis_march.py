import math

def orientation(p, q, r):
    val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])

    if val == 0:
        return 0  # Collinear
    elif val > 0:
        return 1  # Clockwise
    else:
        return 2  # Counter-Clockwise

def dist_sq(p1, p2):
    return (p1[0] - p2[0])**2 + (p1[1] - p2[1])**2

def jarvis_march(points):
    n = len(points)
    if n < 3:
        return points

    start_point = min(points, key=lambda p: (p[0], p[1]))

    hull = []
    
    current_point = start_point
    
    while True:
        hull.append(current_point)
        next_point = points[0]
        if next_point == current_point:
            next_point = points[1]
            
        for candidate_point in points:
            if candidate_point == current_point:
                continue

            o = orientation(current_point, next_point, candidate_point)

            if o == 2:
                next_point = candidate_point
            
            elif o == 0:
                if dist_sq(current_point, candidate_point) > dist_sq(current_point, next_point):
                    next_point = candidate_point
        
        current_point = next_point

        if current_point == start_point:
            break

    return hull

# --- Example Usage ---
if __name__ == "__main__":
    
    # Test Case 1: General points (same as Graham scan example)
    points1 = [(0, 3), (1, 1), (2, 2), (4, 4), 
               (0, 0), (1, 2), (3, 1), (3, 3)]
    
    print("--- Test Case 1 ---")
    print(f"Original points: {points1}")
    hull1 = jarvis_march(points1)
    print(f"Convex Hull: {hull1}")
    # Expected: [(0, 0), (3, 1), (4, 4), (0, 3)] (or equivalent rotation)

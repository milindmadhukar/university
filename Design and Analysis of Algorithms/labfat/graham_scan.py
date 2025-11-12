import math

def graham_scan(points):
    def orientation(p, q, r):
        """
        Calculates the orientation of the ordered triplet (p, q, r).
        
        Returns:
             0: Collinear
             1: Clockwise (CW)
             2: Counter-Clockwise (CCW)
        """
        # (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
        val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])

        if val == 0:
            return 0  # Collinear
        elif val > 0:
            return 1  # Clockwise
        else:
            return 2  # Counter-Clockwise

    n = len(points)
    if n < 3:
        return points

    p0 = min(points, key=lambda p: (p[1], p[0]))

    def sort_key(p):
        angle = math.atan2(p[1] - p0[1], p[0] - p0[0])
        
        dist_sq = (p[0] - p0[0])**2 + (p[1] - p0[1])**2
        
        return (angle, dist_sq)

    other_points = [p for p in points if p != p0]
    
    sorted_points = sorted(other_points, key=sort_key)

    hull = [p0, sorted_points[0]]

    for p in sorted_points[1:]:
        while len(hull) >= 2 and orientation(hull[-2], hull[-1], p) != 2:
            hull.pop()
        
        hull.append(p)

    return hull

if __name__ == "__main__":
    
    # Test Case 1: General points
    points1 = [(0, 3), (1, 1), (2, 2), (4, 4), 
               (0, 0), (1, 2), (3, 1), (3, 3)]
    
    print("--- Test Case 1 ---")
    print(f"Original points: {points1}")
    hull1 = graham_scan(points1)
    print(f"Convex Hull: {hull1}")
    # Expected: [(0, 0), (3, 1), (4, 4), (0, 3)] (or equivalent rotation)

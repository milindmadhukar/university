def greedy_set_cover(universe, subsets_dict):
    elements_to_cover = set(universe)
    cover = []
    
    available_subsets = subsets_dict.copy()

    # Loop until all elements are covered or no more subsets are available
    while elements_to_cover and available_subsets:
        
        # Find the subset that covers the most new elements
        best_subset_key = max(available_subsets, 
                              key=lambda k: len(available_subsets[k].intersection(elements_to_cover)))
        
        best_subset = available_subsets[best_subset_key]
        covered_by_best = best_subset.intersection(elements_to_cover)
        
        # If the best subset doesn't cover any new elements, we're stuck
        if not covered_by_best:
            break 
            
        # Add the best subset to our cover
        cover.append(best_subset_key)
        
        # Remove the covered elements from the set we need to cover
        elements_to_cover.difference_update(best_subset)
        
        # Remove the chosen subset from future consideration
        del available_subsets[best_subset_key]
        
    # Optional: Check if all elements were covered
    # if elements_to_cover:
    #     print("Warning: Not all elements could be covered.")
        
    return cover

# --- Example Usage ---

if __name__ == "__main__":
    # Define the universe of elements
    universe = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    
    # Define the available subsets as a dictionary
    subsets = {
        'A': {1, 2, 3, 8},
        'B': {2, 4, 5, 9},
        'C': {3, 6, 7, 10},
        'D': {4, 5, 7},
        'E': {1, 6, 8, 10},
        'F': {5, 9}
    }
    
    # Find the approximate set cover
    solution = greedy_set_cover(universe, subsets)
    
    print(f"Universe to cover: {universe}")
    print(f"Chosen subsets: {solution}")
    
    # Verify the solution
    covered_elements = set()
    for key in solution:
        covered_elements.update(subsets[key])
    print(f"Elements covered:  {covered_elements}")
    print(f"Cover is valid:  {covered_elements == universe}")

import random

def randomized_quicksort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = random.choice(arr)
        
        less = [x for x in arr if x < pivot]
        equal = [x for x in arr if x == pivot]
        greater = [x for x in arr if x > pivot]
        
        return randomized_quicksort(less) + equal + randomized_quicksort(greater)

my_list = [9, 1, 10, 3, 5, 2, 8, 4, 7, 6]

sorted_list = randomized_quicksort(my_list)

print(f"Original list: {my_list}")
print(f"Sorted list:   {sorted_list}")

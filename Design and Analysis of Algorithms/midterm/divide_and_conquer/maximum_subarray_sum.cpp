#include <iostream>
#include <limits.h>

struct SubarrayInfo {
  int start;
  int end;
  int sum;
};

SubarrayInfo maximum_subarray(int arr[], int low, int high) {
  if (low == high) {
    return {low, high, arr[low]};
  }
  int mid = (low + high) / 2;
  SubarrayInfo left_info = maximum_subarray(arr, low, mid);
  SubarrayInfo right_info = maximum_subarray(arr, mid + 1, high);
  int cross_sum = 0;
  int left_max = INT_MIN;
  int right_max = INT_MIN;
  int left_index, right_index;

  // Find maximum subarray sum in the left part
  for (int i = mid; i >= low; i--) {
    cross_sum += arr[i];
    if (cross_sum > left_max) {
      left_max = cross_sum;
      left_index = i;
    }
  }
  // Reset variables for the right part
  cross_sum = 0;
  // Find maximum subarray sum in the right part
  for (int i = mid + 1; i <= high; i++) {
    cross_sum += arr[i];
    if (cross_sum > right_max) {
      right_max = cross_sum;
      right_index = i;
    }
  }
  int cross_sum_result = left_max + right_max;
  // Return the result with the maximum sum and corresponding indices
  if (left_info.sum >= right_info.sum && left_info.sum >= cross_sum_result) {
    return left_info;
  } else if (right_info.sum >= left_info.sum &&
             right_info.sum >= cross_sum_result) {
    return right_info;
  } else {
    return {left_index, right_index, cross_sum_result};
  }
}

int main() {
  int size;

  std::cout << "Enter the size of array: ";
  std::cin >> size;

  if (size <= 0) {
    std::cout << "Invalid array size!" << std::endl;
    return 1;
  }

  // Dynamically allocate array
  int *arr = new int[size];

  std::cout << "Enter " << size << " elements: ";
  for (int i = 0; i < size; i++) {
    std::cin >> arr[i];
  }

  SubarrayInfo max_info = maximum_subarray(arr, 0, size - 1);

  std::cout << "\nMaximum subarray sum: " << max_info.sum << std::endl;
  std::cout << "Start index: " << max_info.start
            << ", End index: " << max_info.end << std::endl;
  std::cout << "Subarray: [";
  for (int i = max_info.start; i <= max_info.end; i++) {
    std::cout << arr[i];
    if (i < max_info.end) {
      std::cout << ", ";
    }
  }
  std::cout << "]" << std::endl;

  // Clean up
  delete[] arr;

  return 0;
}

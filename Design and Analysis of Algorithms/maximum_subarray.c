// Convert this to C
#include <algorithm>
#include <iostream>
#include <limits.h>
#include <math.h>

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
  } else if (right_info.sum >= left_info.sum && right_info.sum >= cross_sum_result) {
    return right_info;
  } else {
    return {left_index, right_index, cross_sum_result};
  }
}

int main() {
  int size = 8;
  int arr[] = {-3, 2, 5, 6, 7, 1, -3, -2};
  SubarrayInfo max_info = maximum_subarray(arr, 0, size - 1);
  std::cout << "Maximum subarray sum: " << max_info.sum << std::endl;
  std::cout << "Start index: " << max_info.start << ", End index: " << max_info.end << std::endl;
  return 0;
}

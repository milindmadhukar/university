#include <climits>
#include <iostream>
#include <ostream>
struct SubarrayInfo {
  int start, end, sum;
};

SubarrayInfo subarray_sum(int arr[], int low, int high) {
  if (low == high)
    return {low, high, arr[low]};

  int mid = (low + high) / 2;

  SubarrayInfo left_info = subarray_sum(arr, low, mid);
  SubarrayInfo right_info = subarray_sum(arr, mid + 1, high);

  int tmp_sum = 0;
  int left_max = INT_MIN;
  int right_max = INT_MIN;
  int left_index, right_index;

  for (int i = mid; i >= low; i--) {
    tmp_sum += arr[i];
    if (tmp_sum > left_max) {
      left_max = tmp_sum;
      left_index = i;
    }
  }

  tmp_sum = 0;

  for (int i = mid + 1; i <= high; i++) {
    tmp_sum += arr[i];
    if (tmp_sum > right_max) {
      right_max = tmp_sum;
      right_index = i;
    }
  }

  int cross_sum = left_max + right_max;

  if (left_info.sum >= right_info.sum && left_info.sum >= cross_sum) {
    return left_info;
  } else if (right_info.sum >= left_info.sum && right_info.sum >= cross_sum) {
    return right_info;
  } else {
    return {left_index, right_index, cross_sum};
  }
}

int main() {

  int size = 8;
  int arr[] = {-3, 2, 5, 6, 7, 1, -3, -2};
  SubarrayInfo max_info = subarray_sum(arr, 0, size - 1);
  std::cout << "Maximum subarray sum: " << max_info.sum << std::endl;
  std::cout << "Start index: " << max_info.start
            << ", End index: " << max_info.end << std::endl;
  std::cout << "Subarray: [";
  for (int i = max_info.start; i <= max_info.end; i++) {
    std::cout << arr[i] << ", ";
  }
  std::cout << "]";
  return 0;
}

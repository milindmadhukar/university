#include <climits>
#include <iostream>

struct SubarrayInfo {
  int start;
  int end;
  int sum;
};

SubarrayInfo SubarraySum(const int arr[], int low, int high) {
  if (low == high)
    return {low, high, arr[low]};

  int mid = (low + high) / 2;

  SubarrayInfo left_info = SubarraySum(arr, low, mid);
  SubarrayInfo right_info = SubarraySum(arr, mid + 1, high);

  int leftMax = INT_MIN;
  int rightMax = INT_MIN;
  int left_index, right_index;

  int tmp_sum = 0;
  for (int i = mid; i >= 0; i--) {
    tmp_sum += arr[i];
    if (tmp_sum > leftMax) {
      leftMax = tmp_sum;
      left_index = i;
    }
  }

  tmp_sum = 0;
  for (int i = mid + 1; i < high; i++) {
    tmp_sum += arr[i];
    if (tmp_sum > rightMax) {
      rightMax = tmp_sum;
      right_index = i;
    }
  }

  int cross_sum = leftMax + rightMax;

  if (left_info.sum >= right_info.sum && left_info.sum >= cross_sum) {
    return left_info;
  } else if (right_info.sum >= left_info.sum && right_info.sum >= cross_sum) {
    return right_info;
  } else {
    return {left_index, right_index, cross_sum};
  }
}

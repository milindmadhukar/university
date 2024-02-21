#include <iostream>

void SumOfSub(int s, int k, int r, bool *x, int *w, int M) {
  x[k] = 1;
  if (s + w[k] == M) {
    for (int i = 0; i <= k; i++) {
      if (x[i] == 1) {
        std::cout << "1 ";
      } else {
        std::cout << "0 ";
      }
    }
    std::cout << std::endl;
  } else if (s + w[k] + w[k + 1] <= M) {
    SumOfSub(s + w[k], k + 1, r - w[k], x, w, M);
  }
  if (s + r - w[k] >= M && s + w[k + 1] <= M) {
    x[k] = 0;
    SumOfSub(s, k + 1, r - w[k], x, w, M);
  }
}

int main() {
  int w[] = {5, 10, 12, 13, 15, 18};
  int M = 30;
  int n = sizeof(w) / sizeof(w[0]);
  bool x[100];

  int total_sum = 0;
  for (int i = 0; i < 6; i++) {
    total_sum += w[i];
  }

  SumOfSub(0, 0, total_sum, x, w, M);

  std::cout << std::endl;
}

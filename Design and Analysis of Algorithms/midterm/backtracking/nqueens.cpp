#include <cmath>
#include <iostream>
using namespace std;

bool place(int k, int i, int *x) {
  for (int j = 0; j < k; j++) {
    if ((x[j] == i) || abs(x[j] - i) == abs(j - k)) {
      return false;
    }
  }
  return true;
}

void NQueens(int k, int n, int *x) {
  for (int i = 0; i < n; i++) {
    if (place(k, i, x)) {
      x[k] = i;
      if (k == n - 1) {
        for (int j = 0; j < n; j++) {
          cout << "Place queen " << j + 1 << " in row " << j + 1
                    << " and column " << x[j] + 1 << endl;
        }
        cout << endl;
      } else {
        NQueens(k + 1, n, x);
      }
    }
  }
}

int main() {
  int n = 4;
  int x[n];
  NQueens(0, n, x);

  return 0;
}

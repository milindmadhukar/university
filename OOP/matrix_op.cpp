#include <iostream>

using namespace std;

class Matrix {
  int a[3][3];

public:
  Matrix() {
    cout << "Enter the values of matrix" << endl;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        cout << "Enter value at (" << r << "," << c << "): ";
        cin >> a[r][c];
      }
    }
  }
  void operator-() {
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        a[r][c] *= -1;
      }
    }
  }

  void display() {
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        cout << a[r][c] << " ";
      }
      cout << endl;
    }
  }
};

int main() {
  Matrix m = Matrix();
  m.display();
  -m;
  m.display();
}

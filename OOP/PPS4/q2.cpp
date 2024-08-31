#include <iostream>
#include <string>

using namespace std;

class Matrix {
  int **a;
  int rows;
  int columns;

public:
  Matrix(int rows, int columns) {
    this->rows = rows;
    this->columns = columns;

    a = new int *[rows];
    for (int r = 0; r < rows; r++) {
      a[r] = new int[columns];
      for (int c = 0; c < columns; c++) {
        a[r][c] = 0;
      }
    }
  }

  void setValues() {
    cout << "Enter the values of matrix" << endl;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        cout << "Enter value at (" << r << "," << c << "): ";
        cin >> a[r][c];
      }
    }
  }

  int getElement(int r, int c) { return a[r][c]; }
  void setElement(int e, int r, int c) { a[r][c] = e; }

  Matrix operator+(Matrix &another) {
    Matrix res(rows, columns);
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        res.setElement(a[r][c] + another.getElement(r, c), r, c);
      }
    }
    return res;
  }

  Matrix operator-(Matrix &another) {
    Matrix res(rows, columns);
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        res.setElement(a[r][c] - another.getElement(r, c), r, c);
      }
    }
    return res;
  }

  void display() {
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        cout << a[r][c] << " ";
      }
      cout << endl;
    }
  }

  ~Matrix() {
    for (int r = 0; r < rows; r++) {
      delete[] a[r];
    }
    delete[] a;
  }
};

int main() {
  int rows, columns;
  string op;

  cout << "Enter the number of rows: ";
  cin >> rows;
  cout << "Enter the number of columns: ";
  cin >> columns;

  Matrix m1(rows, columns);
  m1.setValues();

  Matrix m2(rows, columns);
  m2.setValues();

  cout << "Enter the operator (+ or -): ";
  cin >> op;

  Matrix result(rows, columns);
  if (op == "+") {
    result = m1 + m2;
    cout << "Matrix addition result:" << endl;
    result.display();
  } else if (op == "-") {
    result = m1 - m2;
    cout << "Matrix subtraction result:" << endl;
    result.display();
  } else {
    cout << "Invalid operator!" << endl;
  }

  return 0;
}


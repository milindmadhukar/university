#include <iostream>

using namespace std;

class Numbers {
  int x, y, z;

public:
  Numbers(int x, int y, int z) {
    this->x = x;
    this->y = y;
    this->z = z;
  }

  void operator-() {
    x = -x;
    y = -y;
    z = -z;
  }

  void display() {
    cout << "X is " << x << endl;
    cout << "Y is " << y << endl;
    cout << "Z is " << z << endl;
  }
};

int main() {
  Numbers num = Numbers(10, 20, 30);
  num.display();
  -num;
  num.display();
  return 0;
}

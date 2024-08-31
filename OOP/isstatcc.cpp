#include <iostream>

class Chutiya {
public:
  static const int a = 5;
  int b;

  Chutiya(int a, int b) {
    this->b = b;
  }

};

int main() {
  printf("%d", Chutiya::a);
  
}

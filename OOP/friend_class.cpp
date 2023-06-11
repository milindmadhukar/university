#include <iostream>

class Your;

class My {
private:
  int x;

protected:
  int y;

public:
  int z;

  friend Your;
};

class Your {
  My m;
public:

  void Fun() {
    m.x = 10;
    m.y = 11;
    m.z = 12;
  }
};

int main() {
  Your obj;
  obj.Fun();
}

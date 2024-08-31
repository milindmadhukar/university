
#include <iostream>

using namespace std;

class Base {
public:
  virtual void print() { cout << "Base function" << endl; }
};

class Derived : public Base {
public:
  void print() { cout << "Derived function" << endl; }
};

int main() {
  Derived derived;
  Base *basePtr = &derived;
  basePtr->print(); // Calls the derived class's overridden function

  return 0;
}

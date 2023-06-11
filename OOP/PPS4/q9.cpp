#include <iostream>

class BaseClass {
public:
  virtual void show() { std::cout << "Base class" << std::endl; }
};

class DerivedClass : public BaseClass {
public:
  void show() override { std::cout << "Derived class" << std::endl; }
};

class FriendClass {
public:
  friend void BaseClass::show();
};

int main() {

  FriendClass fc;
  BaseClass *basePtr = new BaseClass();
  basePtr->show();

  BaseClass *derivedPtr = new DerivedClass();
  derivedPtr->show();

  delete basePtr;
  delete derivedPtr;

  return 0;
}

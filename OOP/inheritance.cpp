#include <iostream>

class Animal {
public:
  int legs = 4;
  void speak() { std::cout << "Animal is speaking"; }

protected:
  int lauda;

private:
  bool canFly = true;
  void fly() { std::cout << "Flying..."; }
};


class Cow {
public:
  int legs = 4;
  void speak() { std::cout << "Animal is speaking"; }

protected:
  int lauda;

private:
  bool canFly = true;
  void fly() { std::cout << "Flying..."; }
};

class Dog : private Animal{
public:
  void bark() { std::cout << "Woof!" << lauda; }

private:
  bool isHungry = false;
};

int main() {
  Dog d;

  return 0;
}

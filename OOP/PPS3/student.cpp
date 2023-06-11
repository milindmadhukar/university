// 1. Write a code with Student as a base class, Mark as intermediate class and
// Result as a derived class. • The base class named Student with data members
// id, and name and getstu() and putstu() are the methods to read and display
// the id and name. • The intermediate class named Marks with data members m1,
// m2, m3 and getmarks() and putmarks() are the methods to read and display the
// marks. • The derived class named Result with total, average as a data members
// and show() as the method to display the total and average of marks.

#include <iostream>
#include <string>

using std::endl;

class Student {
  int id;
  std::string name;

public:
  void getstu() {
    std::cout << "Enter ID:";
    std::cin >> id;
    std::cout << "Enter Name:";
    std::cin >> name;
  }
  void putstud() {
    std::cout << "ID:" << id << endl;
    std::cout << "Name:" << name << endl;
  }
};

class Mark : public Student {
public:
  int m1, m2, m3;
  void getmarks() {
    std::cout << "Enter mark m1:";
    std::cin >> m1;
    std::cout << "Enter mark m2:";
    std::cin >> m2;
    std::cout << "Enter mark m3:";
    std::cin >> m3;
  }

  void putmarks() {
    std::cout << "Mark1:" << m1 << std::endl;
    std::cout << "Mark2:" << m2 << std::endl;
    std::cout << "Mark3:" << m3 << std::endl;
  }
};

class Result : public Mark {
  int total;
  float avg;

public:
  void show() {
    total = m1 + m2 + m3;
    avg = total / 3.0f;
    std::cout << "The total is:" << total << std::endl;
    std::cout << "The average is:" << avg << std::endl;
  }
};

int main() {
  Result a;
  a.getstu();
  a.getmarks();
  a.putstud();
  a.putmarks();
  a.show();
  return 0;
}

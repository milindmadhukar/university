#include <iostream>
#include <string>

using namespace std;

class CString {
  string s;

public:
  CString(string s) { this->s = s; }

  void operator+(string another) { s = s + another; }

  bool operator==(string another) { return s == another; }

  void display() { cout << "The string is " << s << endl; }
};

int main() {
  CString str = CString("Hello");
  str.display();
  str + "World";
  str.display();

  string a = "HelloWorld";

  bool eq = str == a;

  if (eq) {
    cout << "The strings are equal" << endl;
  } else {
    cout << "The strings are not equal" << endl;
  }
}

#include <cstring>
#include <iostream>
#include <string>

using namespace std;

class mystring {
  char str[100];

public:
  mystring(char str[100]) { strcpy(this->str, str); }

  void operator!() {
    int idx = 0;
    char c = str[idx];
    while (c != '\0') {
      if (c >= 65 && c < 97) {
        str[idx] += 32;
      } else if (c >= 97 && c < 124) {
        str[idx] -= 32;
      }
      c = str[++idx];
    }
  }
  void display() {
    cout << str << endl;
  }
};

int main() {
  char str[100] = "Hello";
  mystring mystr = mystring(str);
  mystr.display();
  !mystr;
  mystr.display();
}

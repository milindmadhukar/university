// Create a class string that reads the string and its length. Write a program to overload the
// operator < and > to compare two strings. if s1 i< s2 then print "String s1 is smaller than
// String s2", if s2< s1 then print "String s2 is smaller than String s1" otherwise print "Both
// the Strings s1 and s2 are Equal".

#include <iostream>
#include <string>

class String {
private:
    std::string str;
public:
    String(const std::string& s) : str(s) {}

    int length() const {
        return str.length();
    }

    friend bool operator<(const String& s1, const String& s2) {
        return s1.str < s2.str;
    }

    friend bool operator>(const String& s1, const String& s2) {
        return s1.str > s2.str;
    }
};

int main() {
    std::string input1, input2;
    std::cout << "Enter the first string: ";
    std::cin >> input1;
    std::cout << "Enter the second string: ";
    std::cin >> input2;

    String s1(input1);
    String s2(input2);

    if (s1 < s2) {
        std::cout << "String s1 is smaller than String s2" << std::endl;
    } else if (s2 < s1) {
        std::cout << "String s2 is smaller than String s1" << std::endl;
    } else {
        std::cout << "Both the Strings s1 and s2 are equal" << std::endl;
    }

    return 0;
}


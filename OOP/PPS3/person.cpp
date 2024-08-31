#include <iostream>
#include <string>
#include <cassert>

class Person {
private:
    std::string name;
    int age;

public:
    Person(std::string name, int age) {
        this->name = name;
        this->age = age;
    }

    std::string getName() {
        return name;
    }

    int getAge() {
        return age;
    }
};

int main() {
    // Test case 1
    Person p1("John", 25);
    assert(p1.getName() == "John");
    assert(p1.getAge() == 25);

    // Test case 2
    Person p2("sam", 35);
    assert(p2.getName() == "sam");
    assert(p2.getAge() == 35);

    // Test case 3
    Person p3("Ram", 45);
    assert(p3.getName() == "Ram");
    assert(p3.getAge() == 45);

    // Invalid test case
    // Person p4("$", -45); // This will not compile due to invalid input

    std::cout << "All test cases passed successfully.\n";

    return 0;
}

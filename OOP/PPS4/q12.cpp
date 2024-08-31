
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

struct Employee {
    std::string name;
    int age;
    float salary;
};

bool compare_name(const Employee& emp1, const Employee& emp2) {
    return emp1.name < emp2.name;
}

void display_employee(const Employee& emp) {
    std::cout << "- Name: " << emp.name << ", Age: " << emp.age << ", Salary: " << emp.salary << std::endl;
}

int main() {
    std::vector<Employee> employees = {
        {"John", 30, 5000.0},
        {"Alice", 25, 4500.0},
        {"David", 35, 5500.0},
        {"Michael", 28, 6000.0},
        {"Emily", 32, 5500.0},
        {"Daniel", 26, 5000.0}
    };

    std::cout << "Employee records before sorting:" << std::endl;
    for (const auto& emp : employees) {
        display_employee(emp);
    }

    std::sort(employees.begin(), employees.end(), compare_name);

    std::cout << "\nEmployee records after sorting:" << std::endl;
    for (const auto& emp : employees) {
        display_employee(emp);
    }

    return 0;
}

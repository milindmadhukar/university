#include <iostream>

class Employee {
public:
    virtual int calculateGrossPay() const = 0;
};

class RegularEmployee : public Employee {
private:
    int basic;
    int hra;
    int da;
public:
    RegularEmployee(int b, int h, int d) : basic(b), hra(h), da(d) {}

    int calculateGrossPay() const override {
        return basic + hra + da;
    }
};

class DailyWagesEmployee : public Employee {
private:
    int wagesPerHour;
    int numberOfHours;
public:
    DailyWagesEmployee(int w, int n) : wagesPerHour(w), numberOfHours(n) {}

    int calculateGrossPay() const override {
        return wagesPerHour * numberOfHours;
    }
};

class ConsolidatedEmployee : public Employee {
private:
    int consolidatedPay;
public:
    ConsolidatedEmployee(int c) : consolidatedPay(c) {}

    int calculateGrossPay() const override {
        return consolidatedPay;
    }
};

int main() {
    int basic, hra, da, wagesPerHour, numberOfHours, consolidatedPay;

    std::cout << "Enter the components for calculating gross pay:" << std::endl;
    std::cout << "Basic: ";
    std::cin >> basic;
    std::cout << "HRA: ";
    std::cin >> hra;
    std::cout << "DA: ";
    std::cin >> da;
    std::cout << "Wages per hour: ";
    std::cin >> wagesPerHour;
    std::cout << "Number of hours: ";
    std::cin >> numberOfHours;
    std::cout << "Consolidated Pay: ";
    std::cin >> consolidatedPay;

    Employee* regularEmployee = new RegularEmployee(basic, hra, da);
    Employee* dailyWagesEmployee = new DailyWagesEmployee(wagesPerHour, numberOfHours);
    Employee* consolidatedEmployee = new ConsolidatedEmployee(consolidatedPay);

    std::cout << "Regular employees = " << regularEmployee->calculateGrossPay() << std::endl;
    std::cout << "Daily wages = " << dailyWagesEmployee->calculateGrossPay() << std::endl;
    std::cout << "Consolidated = " << consolidatedEmployee->calculateGrossPay() << std::endl;

    return 0;
}

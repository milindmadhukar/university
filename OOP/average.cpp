// Print the average of three numbers entered by the user by creating a class named
// 'Average' having a function to calculate and print the average without creating any
// object of the Average class.


#include <iostream>
using namespace std;

class Average {
public:
    static void calculate_average() {
        float num1, num2, num3, avg;
        cout << "Enter first number: ";
        cin >> num1;
        cout << "Enter second number: ";
        cin >> num2;
        cout << "Enter third number: ";
        cin >> num3;
        avg = (num1 + num2 + num3) / 3;
        cout << "The average of the three numbers is: " << avg << endl;
    }
};

int main() {
    Average::calculate_average();
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    double num;
    cout << "Enter a number: ";
    cin >> num;
    
    if (num < 0) {
        cout << "Invalid" << endl;
    }
    else if ((int)num % 2 == 0) {
        cout << "Even" << endl;
    }
    else {
        cout << "Odd" << endl;
    }
    
    return 0;
}

#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

int main() {
    int n;
    char c;
    string expression;
    unordered_map<char, char> variables; // Map variable names to their types (float or int)

    cout << "Enter the number of variables: ";
    cin >> n;

    // Input variables and their types
    for (int i = 0; i < n; ++i) {
        char var, type;
        cout << "Enter the variable[" << i << "]: ";
        cin >> var;
        cout << "Enter the variable-type[" << i << "] (float-f, int-i): ";
        cin >> type;
        variables[var] = type;
    }

    // Input the expression
    cout << "Enter the Expression (end with $): ";
    cin.ignore(); // To consume the leftover newline
    getline(cin, expression, '$');

    // Check if the expression involves division
    bool requiresFloat = (expression.find('/') != string::npos);

    // Determine the type of the first variable
    char firstVar = expression[0];
    if (variables.count(firstVar)) {
        if (requiresFloat && variables[firstVar] != 'f') {
            cout << "Identifier " << firstVar << " must be a float type..!\n";
        } else {
            cout << "The datatype is correctly defined..!\n";
        }
    } else {
        cout << "Undefined variable: " << firstVar << "\n";
    }

    return 0;
}

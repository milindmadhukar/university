#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
    vector<string> intermediateCode;
    string line;

    cout << "Enter the set of intermediate code (type 'exit' to finish):\n";
    while (true) {
        cin >> line;
        if (line == "exit") break;
        intermediateCode.push_back(line);
    }

    cout << "\nTarget Code Generation";
    cout << "\n-----------------------";

    for (size_t i = 0; i < intermediateCode.size(); ++i) {
        const string& code = intermediateCode[i];
        string operation;

        switch (code[3]) {
            case '+': operation = "ADD"; break;
            case '-': operation = "SUB"; break;
            case '*': operation = "MUL"; break;
            case '/': operation = "DIV"; break;
            default: throw runtime_error("Invalid operator in intermediate code");
        }

        cout << "\nMOV " << code[2] << ", R" << i;
        cout << "\n" << operation << " " << code[4] << ", R" << i;
        cout << "\nMOV R" << i << ", " << code[0];
    }

    return 0;
}


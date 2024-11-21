#include <iostream>
#include <string>
using namespace std;

int main() {
    string production, alpha, beta;
    char non_terminal;

    cout << "Enter the Production as E->E|A: ";
    cin >> production;

    non_terminal = production[0];

    // Check if the grammar is left recursive
    if (production[3] == non_terminal) {
        size_t index = 4; // Start after "E->E"
        
        // Extract alpha (characters after the first non-terminal until '|')
        while (index < production.size() && production[index] != '|') {
            alpha += production[index++];
        }

        if (index == production.size()) { // No vertical bar found
            cout << "This Grammar CAN'T BE REDUCED.\n";
            return 0;
        }

        index++; // Skip '|'

        // Extract beta (characters after '|')
        while (index < production.size()) {
            beta += production[index++];
        }

        if (beta.empty()) { // No characters after '|'
            cout << "This Grammar CAN'T BE REDUCED.\n";
            return 0;
        }

        // Display the grammar without left recursion
        cout << "\nGrammar Without Left Recursion:\n";
        cout << non_terminal << "->" << beta << non_terminal << "'\n";
        cout << non_terminal << "'->" << alpha << non_terminal << "'|#\n";
    } else {
        cout << "\nThis Grammar is not LEFT RECURSIVE.\n";
    }

    return 0;
}

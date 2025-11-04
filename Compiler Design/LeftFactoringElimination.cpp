
#include <iostream>
#include <string>
using namespace std;

int main() {
    string production, part1, part2, modifiedGram, newGram;
    int pos = 0;

    cout << "Enter Production (e.g., A->aB|aC): A->";
    getline(cin, production);

    // Split production into two parts at '|'
    size_t delimiter = production.find('|');
    part1 = production.substr(0, delimiter);
    part2 = production.substr(delimiter + 1);

    // Find common prefix
    while (pos < part1.size() && pos < part2.size() && part1[pos] == part2[pos]) {
        modifiedGram += part1[pos++];
    }

    // Handle remaining parts
    newGram = part1.substr(pos) + "|" + part2.substr(pos);

    // Add new non-terminal
    modifiedGram += "X";

    // Output the result
    cout << "\nGrammar Without Left Factoring:\n";
    cout << "A->" << modifiedGram << endl;
    cout << "X->" << newGram << endl;

    return 0;
}

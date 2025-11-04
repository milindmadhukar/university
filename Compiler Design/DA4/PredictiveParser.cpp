#include <cctype>
#include <iostream>
#include <map>
#include <set>
#include <string>
#include <vector>

using namespace std;

class LLParser {
private:
  vector<string> productions;
  map<char, set<char>> first;
  map<char, set<char>> follow;
  map<char, map<char, string>> parseTable;
  set<char> terminals;
  set<char> nonTerminals;

  void computeFirst(char symbol) {
    if (first.count(symbol))
      return;

    for (const auto &prod : productions) {
      if (prod[0] == symbol) {
        if (prod[2] == '#') {
          first[symbol].insert('#');
        } else if (!isupper(prod[2])) {
          first[symbol].insert(prod[2]);
        } else {
          computeFirst(prod[2]);
          first[symbol].insert(first[prod[2]].begin(), first[prod[2]].end());
        }
      }
    }
  }

  void computeFollow(char symbol) {
    if (symbol == productions[0][0]) {
      follow[symbol].insert('$');
    }

    for (const auto &prod : productions) {
      for (size_t i = 2; i < prod.length(); ++i) {
        if (prod[i] == symbol) {
          if (i == prod.length() - 1) {
            if (prod[0] != symbol) {
              computeFollow(prod[0]);
              follow[symbol].insert(follow[prod[0]].begin(),
                                    follow[prod[0]].end());
            }
          } else {
            char next = prod[i + 1];
            if (!isupper(next) && next != '#') {
              follow[symbol].insert(next);
            } else if (isupper(next)) {
              computeFirst(next);
              for (char f : first[next]) {
                if (f != '#')
                  follow[symbol].insert(f);
              }
              if (first[next].count('#')) {
                computeFollow(prod[0]);
                follow[symbol].insert(follow[prod[0]].begin(),
                                      follow[prod[0]].end());
              }
            }
          }
        }
      }
    }
  }

  void constructParseTable() {
    for (const auto &prod : productions) {
      char nonTerm = prod[0];
      char firstSymbol = prod[2];

      if (firstSymbol == '#') {
        for (char term : follow[nonTerm]) {
          parseTable[nonTerm][term] = prod;
        }
      } else if (!isupper(firstSymbol)) {
        parseTable[nonTerm][firstSymbol] = prod;
      } else {
        computeFirst(firstSymbol);
        for (char term : first[firstSymbol]) {
          if (term != '#') {
            parseTable[nonTerm][term] = prod;
          }
        }
        if (first[firstSymbol].count('#')) {
          for (char term : follow[nonTerm]) {
            parseTable[nonTerm][term] = prod;
          }
        }
      }
    }
  }

public:
  void inputGrammar() {
    int count;
    cout << "Enter number of productions: ";
    cin >> count;
    cin.ignore();

    cout << "Enter productions (format: A=BC or A=#):" << endl;
    for (int i = 0; i < count; ++i) {
      string prod;
      getline(cin, prod);
      productions.push_back(prod);
      nonTerminals.insert(prod[0]);
      for (char c : prod.substr(2)) {
        if (!isupper(c) && c != '#')
          terminals.insert(c);
      }
    }
    terminals.insert('$');
  }

  void generateParseTable() {
    for (char nonTerm : nonTerminals) {
      computeFirst(nonTerm);
    }

    for (char nonTerm : nonTerminals) {
      computeFollow(nonTerm);
    }

    constructParseTable();
  }
  void displayParseTable() {
    cout << "\nLL(1) Parsing Table:\n\n";

    cout << "NT\t";
    for (char term : terminals) {
      cout << term << "\t";
    }
    cout << "\n";

    cout << string(8 + terminals.size() * 8, '-') << "\n";

    for (char nonTerm : nonTerminals) {
      cout << nonTerm << "\t";
      for (char term : terminals) {
        if (parseTable[nonTerm].count(term)) {
          cout << parseTable[nonTerm][term] << "\t";
        } else {
          cout << "\t";
        }
      }
      cout << "\n";
    }
  }

  bool parse(const string &input) {
    string stack = "$";
    stack += productions[0][0];
    size_t index = 0;

    cout << "\nParsing Steps:\n";
    cout << "Stack\tInput\tAction\n";

    while (!stack.empty()) {
      cout << stack << "\t" << input.substr(index) << "\t";

      if (stack.back() == input[index]) {
        if (stack.back() == '$') {
          cout << "Accept\n";
          return true;
        }
        stack.pop_back();
        index++;
        cout << "Match " << input[index - 1] << "\n";
      } else if (islower(stack.back()) || stack.back() == '$') {
        cout << "Error\n";
        return false;
      } else {
        char nonTerm = stack.back();
        char term = input[index];
        stack.pop_back();

        if (parseTable[nonTerm].count(term)) {
          string prod = parseTable[nonTerm][term];
          if (prod[2] != '#') {
            for (int i = prod.length() - 1; i >= 2; --i) {
              stack += prod[i];
            }
          }
          cout << "Output " << prod << "\n";
        } else {
          cout << "Error\n";
          return false;
        }
      }
    }

    return false;
  }
};

int main() {
  LLParser parser;
  parser.inputGrammar();
  parser.generateParseTable();
  parser.displayParseTable();

  string input;
  cout << "\nEnter input string: ";
  cin >> input;
  input += '$';

  if (parser.parse(input)) {
    cout << "\nInput string is accepted!\n";
  } else {
    cout << "\nInput string is rejected!\n";
  }

  return 0;
}

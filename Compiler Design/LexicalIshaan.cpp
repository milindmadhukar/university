#include <cctype>
#include <iostream>
#include <sstream>
#include <string>
#include <unordered_set>
#include <vector>

using namespace std;

unordered_set<string> keywords = {
    "auto",     "break",  "case",    "char",   "const",    "continue",
    "default",  "do",     "double",  "else",   "enum",     "extern",
    "float",    "for",    "goto",    "if",     "int",      "long",
    "register", "return", "short",   "signed", "sizeof",   "static",
    "struct",   "switch", "typedef", "union",  "unsigned", "void",
    "volatile", "while"};

unordered_set<char> operators = {'=', '+', '-', '*', '/', '%'};

unordered_set<char> delimiters = {',', ';', '(', ')', '{', '}'};

bool findKeyword(const string &str) {
  return keywords.find(str) != keywords.end();
}

bool isOperator(char ch) { return operators.find(ch) != operators.end(); }

bool isDelimiter(char ch) { return delimiters.find(ch) != delimiters.end(); }

void lexicalAnalysis(const string &input) {
  vector<string> variables, literals, operatorTokens, constants, keywordTokens,
      specialSymbols;
  istringstream iss(input);
  string line, token;

  while (getline(iss, line)) {
    for (size_t i = 0; i < line.size();) {
      if (isspace(line[i])) {
        ++i;
        continue;
      }
      if (isalpha(line[i])) {
        token.clear();
        while (i < line.size() && (isalnum(line[i]) || line[i] == '_')) {
          token += line[i++];
        }
        if (findKeyword(token)) {
          keywordTokens.push_back(token);
        } else {
          variables.push_back(token);
        }
      } else if (isdigit(line[i])) {
        token.clear();
        while (i < line.size() && isdigit(line[i])) {
          token += line[i++];
        }
        constants.push_back(token);
      } else if (line[i] == '"') {
        token.clear();
        token += line[i++];
        while (i < line.size() && line[i] != '"') {
          token += line[i++];
        }
        if (i < line.size()) {
          token += line[i++];
        }
        literals.push_back(token);
      } else if (isOperator(line[i])) {
        token.clear();
        token += line[i++];
        operatorTokens.push_back(token);
      } else if (isDelimiter(line[i])) {
        token.clear();
        token += line[i++];
        specialSymbols.push_back(token);
      } else {
        ++i;
      }
    }
  }

  cout << "Lexeme of variables: ";
  for (const auto &v : variables)
    cout << v << " ";
  cout << "\nLexeme of literals: ";
  for (const auto &l : literals)
    cout << l << " ";
  cout << "\nLexeme of operators: ";
  for (const auto &o : operatorTokens)
    cout << o << " ";
  cout << "\nLexeme of constants: ";
  for (const auto &c : constants)
    cout << c << " ";
  cout << "\nLexeme of keywords: ";
  for (const auto &k : keywordTokens)
    cout << k << " ";
  cout << "\nLexeme of special symbols or delimiters: ";
  for (const auto &s : specialSymbols)
    cout << s << " ";
  cout << endl;
}

int main() {
  string input, line;
  cout << "Enter your multi-line program (Enter an empty line to finish):\n";
  while (getline(cin, line) && !line.empty()) {
    input += line + "\n";
  }
  lexicalAnalysis(input);
  return 0;
}

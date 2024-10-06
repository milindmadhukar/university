#include <iostream>
#include <string>
#include <cstdlib>
#include <iomanip>

std::string input;
int position = 0;
char lookahead;

void match(char expected);
char nextChar();
void E();
void EDash();
void T();
void TDash();
void F();
void error(const std::string& message);
void printOperation(const std::string& operation);

char nextChar() {
  if (position < input.length()) {
    return input[position++];
  }
  return '\0';
}

void match(char expected) {
  if (lookahead == expected) {
    lookahead = nextChar();
  } else {
    error("Unexpected character");
  }
}

void error(const std::string& message) {
  std::cerr << "Error: " << message << std::endl;
  std::exit(1);
}

void printOperation(const std::string& operation) {
  std::cout << std::left << std::setw(20) << operation << " | ";
  std::cout << std::setw(20) << input.substr(position) << std::endl;
}

void E() {
  printOperation("E -> TE'");
  T();
  EDash();
}

void EDash() {
  if (lookahead == '+') {
    printOperation("E' -> +TE'");
    match('+');
    T();
    EDash();
  } else {
    printOperation("E' -> ε");
  }
}

void T() {
  printOperation("T -> FT'");
  F();
  TDash();
}

void TDash() {
  if (lookahead == '*') {
    printOperation("T' -> *FT'");
    match('*');
    F();
    TDash();
  } else {
    printOperation("T' -> ε");
  }
}

void F() {
  if (lookahead == '(') {
    printOperation("F -> (E)");
    match('(');
    E();
    match(')');
  } else if (lookahead == 'i') {
    printOperation("F -> i");
    match('i');
  } else {
    error("Unexpected symbol in F production");
  }
}

int main() {
  std::cout << "Enter an expression: ";
  std::getline(std::cin, input);

  position = 0;
  lookahead = nextChar();

  std::cout << std::left << std::setw(20) << "Operation" << " | ";
  std::cout << std::setw(20) << "Remaining Input" << std::endl;
  std::cout << std::string(42, '-') << std::endl;

  E();

  if (lookahead != '\0') {
    error("Unexpected characters at end of input");
  }

  std::cout << std::string(42, '-') << std::endl;
  std::cout << "Parsing completed successfully." << std::endl;

  return 0;
}

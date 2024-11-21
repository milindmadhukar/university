#include <cstdlib>
#include <iomanip>
#include <iostream>
#include <string>

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
void error(const std::string &message);

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

void error(const std::string &message) {
  std::cerr << "Error: " << message << std::endl;
  std::exit(1);
}

void E() {
  std::cout << ("E -> TE'") << std::endl;
  T();
  EDash();
}

void EDash() {
  if (lookahead == '+') {
    std::cout << ("E' -> +TE'") << std::endl;
    match('+');
    T();
    EDash();
  } else {
    std::cout << ("E' -> ε") << std::endl;
  }
}

void T() {
  std::cout << ("T -> FT'") << std::endl;
  F();
  TDash();
}

void TDash() {
  if (lookahead == '*') {
    std::cout << ("T' -> *FT'") << std::endl;
    match('*');
    F();
    TDash();
  } else {
    std::cout << ("T' -> ε") << std::endl;
  }
}

void F() {
  if (lookahead == '(') {
    std::cout << ("F -> (E)") << std::endl;
    match('(');
    E();
    match(')');
  } else if (lookahead == 'i') {
    std::cout << ("F -> i")  << std::endl;
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

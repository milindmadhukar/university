#include <cctype>
#include <iostream>
#include <string>
#include <vector>

struct Expression {
  char lhs;
  std::string rhs;
};

void eliminateDeadCode(std::vector<Expression> &expressions) {
  int used[26] = {0};

  for (const auto &expr : expressions) {
    for (char ch : expr.rhs) {
      if (isalpha(ch)) {
        used[ch - 'a'] = 1;
      }
    }
  }

  std::vector<Expression> newExpressions;
  for (const auto &expr : expressions) {
    if (expr.lhs == 'r' || used[expr.lhs - 'a']) {
      newExpressions.push_back(expr);
    }
  }
  expressions = std::move(newExpressions);
}

void eliminateCommonSubexpressions(std::vector<Expression> &expressions) {
  for (size_t i = 0; i < expressions.size() - 1; ++i) {
    for (size_t j = i + 1; j < expressions.size(); ++j) {
      if (expressions[i].rhs == expressions[j].rhs) {
        char replaceWith = expressions[i].lhs;
        char toReplace = expressions[j].lhs;

        for (size_t k = j + 1; k < expressions.size(); ++k) {
          for (char &ch : expressions[k].rhs) {
            if (ch == toReplace) {
              ch = replaceWith;
            }
          }
        }
        expressions[j].lhs = '\0';
      }
    }
  }

  std::vector<Expression> newExpressions;
  for (const auto &expr : expressions) {
    if (expr.lhs != '\0') {
      newExpressions.push_back(expr);
    }
  }
  expressions = std::move(newExpressions);
}

void printExpressions(const std::vector<Expression> &expressions) {
  for (const auto &expr : expressions) {
    std::cout << expr.lhs << "=" << expr.rhs << "\n";
  }
}

int main() {
  int count;
  std::cout << "Enter the number of expressions: ";
  std::cin >> count;

  std::vector<Expression> expressions(count);

  for (int i = 0; i < count; ++i) {
    std::cout << "left: ";
    std::cin >> expressions[i].lhs;
    std::cout << "right: ";
    std::cin >> expressions[i].rhs;
  }

  std::cout << "\nIntermediate Code\n";
  printExpressions(expressions);

  eliminateDeadCode(expressions);
  std::cout << "\nAfter Dead Code Elimination\n";
  printExpressions(expressions);

  eliminateCommonSubexpressions(expressions);
  std::cout << "\nEliminate Common Expression\n";
  printExpressions(expressions);

  std::cout << "\nOptimized Code\n";
  printExpressions(expressions);

  return 0;
}

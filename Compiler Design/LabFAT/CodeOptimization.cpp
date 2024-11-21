#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>

struct Operation {
  char left;
  std::string right;
};

void printCode(const std::string &title, const std::vector<Operation> &code) {
  std::cout << title << '\n';
  for (const auto &op : code) {
    std::cout << op.left << " = " << op.right << '\n';
  }
}

int main() {
  int n;
  std::cout << "Enter the Number of Values: ";
  std::cin >> n;

  std::vector<Operation> operations(n), optimized;

  // Input operations
  for (int i = 0; i < n; ++i) {
    std::cout << "left: ";
    std::cin >> operations[i].left;
    std::cout << "right: ";
    std::cin >> operations[i].right;
  }

  printCode("Intermediate Code", operations);

  // Dead code elimination
  for (int i = 0; i < n; ++i) {
    char temp = operations[i].left;
    bool isUsed = false;
    for (int j = i + 1; j < n; ++j) {
      if (operations[j].right.find(temp) != std::string::npos) {
        isUsed = true;
        break;
      }
    }
    if (i == n - 1 || isUsed) {
      optimized.push_back(operations[i]);
    }
  }

  printCode("\nAfter Dead Code Elimination", optimized);

  // Eliminate common expressions
  for (size_t i = 0; i < optimized.size(); ++i) {
    for (size_t j = i + 1; j < optimized.size(); ++j) {
      if (optimized[i].right == optimized[j].right) {
        char replace = optimized[j].left;
        optimized[j].left = optimized[i].left;

        // Update references
        for (auto &op : optimized) {
          auto pos = op.right.find(replace);
          if (pos != std::string::npos) {
            op.right[pos] = optimized[i].left;
          }
        }
      }
    }
  }

  printCode("Eliminate Common Expression", optimized);

  // Remove redundant assignments (keep only the first occurrence)
  std::vector<Operation> finalCode;
  std::unordered_set<std::string> seen;
  for (const auto &op : optimized) {
    if (seen.find(op.right) == seen.end()) {
      finalCode.push_back(op);
      seen.insert(op.right);
    }
  }

  printCode("Optimized Code", finalCode);

  return 0;
}

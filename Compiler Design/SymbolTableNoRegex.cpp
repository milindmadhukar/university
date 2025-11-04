#include <iostream>
#include <sstream>
#include <string>
#include <unordered_map>
#include <vector>

struct SymbolInfo {
  std::string name;
  std::string dataType;
  int size;
  int lineOfDecleration;
};

class SymbolTable {
private:
  std::unordered_map<std::string, SymbolInfo> table;

  int getDataTypeSize(const std::string &dataType) {
    if (dataType == "int" || dataType == "float")
      return 4;
    if (dataType == "double" || dataType == "long")
      return 8;
    if (dataType == "char" || dataType == "bool")
      return 1;
    return 0; // Unknown type
  }

public:
  void insert(const std::string &name, const std::string &dataType,
              int lineOfDecleration) {
    SymbolInfo info;
    info.name = name;
    info.dataType = dataType;
    info.size = getDataTypeSize(dataType);
    info.lineOfDecleration = lineOfDecleration;
    table[name] = info;
  }

  void display() {
    std::cout << "Symbol Table:\n";
    std::cout << "Name\tData Type\tSize\tLine Of Decleration\n";
    for (const auto &entry : table) {
      const SymbolInfo &info = entry.second;
      std::cout << info.name << "\t" << info.dataType << "\t\t" << info.size
                << "\t" << info.lineOfDecleration << "\n";
    }
  }
};

std::vector<std::string> split(const std::string &s, char delimiter) {
  std::vector<std::string> tokens;
  std::string token;
  std::istringstream tokenStream(s);
  while (std::getline(tokenStream, token, delimiter)) {
    tokens.push_back(token);
  }
  return tokens;
}

std::string trim(const std::string &str) {
  size_t first = str.find_first_not_of(" \t");
  if (std::string::npos == first) {
    return str;
  }
  size_t last = str.find_last_not_of(" \t");
  return str.substr(first, (last - first + 1));
}

void processCode(const std::string &code, SymbolTable &symbolTable) {
  std::istringstream iss(code);
  std::string line;
  int lineOfDecleration = 0;

  std::vector<std::string> dataTypes = {"int",  "float", "double",
                                        "char", "bool",  "long"};

  while (std::getline(iss, line)) {
    lineOfDecleration++;
    line = trim(line);

    // Check if the line starts with a known data type
    for (const auto &dataType : dataTypes) {
      if (line.substr(0, dataType.length()) == dataType) {
        // Remove the data type from the line
        std::string variableList = line.substr(dataType.length());

        // Remove semicolon if present
        if (!variableList.empty() && variableList.back() == ';') {
          variableList.pop_back();
        }

        // Split the variable list by commas
        std::vector<std::string> variables = split(variableList, ',');

        for (auto &var : variables) {
          var = trim(var);

          // Remove any initialization part
          size_t equalsPos = var.find('=');
          if (equalsPos != std::string::npos) {
            var = var.substr(0, equalsPos);
          }

          var = trim(var);

          if (!var.empty()) {
            symbolTable.insert(var, dataType, lineOfDecleration);
          }
        }

        break; // We've processed this line, move to the next
      }
    }
  }
}

int main() {
  std::string code;
  std::string line;

  std::cout << "Enter your code (type 'END' on a new line to finish):\n";
  while (std::getline(std::cin, line) && line != "END") {
    code += line + "\n";
  }

  SymbolTable symbolTable;
  processCode(code, symbolTable);
  symbolTable.display();

  return 0;
}

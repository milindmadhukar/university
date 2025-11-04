#include <algorithm>
#include <iostream>
#include <sstream>
#include <string>
#include <unordered_map>
#include <vector>

struct SymbolInfo {
  std::string name;
  std::string dataType;
  int size;
  int line_of_declaration;
};

std::vector<std::string> split(const std::string &s, char splitChar) {
  std::vector<std::string> tokens;
  std::string token;
  std::istringstream tokenStream(s);
  while (std::getline(tokenStream, token, splitChar)) {
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

class SymbolTable {
private:
  std::unordered_map<std::string, SymbolInfo> table;
  int getSizeOfDatatype(std::string type) {
    if (type == "double" || type == "long")
      return 8;
    if (type == "float" || type == "int") {
      return 4;
    }
    if (type == "char" || type == "bool")
      return 1;
    return 0;
  }

public:
  void insert(const std::string &name, const std::string &dataType,
              int line_of_declaration) {
    SymbolInfo info;
    info.name = name;
    info.dataType = dataType;
    info.size = getSizeOfDatatype(dataType);
    info.line_of_declaration = line_of_declaration;
    table[name] = info;
  }
  void display() {
    std::cout << "Symbol Table:\n";
    std::cout << "Name\tData Type\tSize\tLine Of Decleration\n";
    for (const auto &val : table) {
      const SymbolInfo &info = val.second;
      std::cout << info.name << "\t" << info.dataType << "\t\t" << info.size
                << "\t" << info.line_of_declaration << "\n";
    }
  }
};

void processCode(std::string code, SymbolTable &symbolTable) {
  std::istringstream codestream(code);
  std::string line;
  int lineNumber = 0;
  std::vector<std::string> dataTypes = {"double", "long", "int",
                                        "float",  "char", "bool"};
  while (std::getline(codestream, line)) {
    lineNumber++;
    line = trim(line);
    for (const auto &dataType : dataTypes) {
      if (line.substr(0, dataType.length()) == dataType) {
        std::string variableList = line.substr(dataType.length());
        if (!variableList.empty() && variableList.back() == ';') {
          variableList.pop_back();
        }
        std::vector<std::string> variables = split(variableList, ',');
        for (auto &var : variables) {
          var = trim(var);
          size_t equalsPos = var.find('=');
          if (equalsPos != std::string::npos) {
            var = var.substr(0, equalsPos);
          }
          var = trim(var);
          if (!var.empty()) {
            symbolTable.insert(var, dataType, lineNumber);
          }
        }
        break;
      }
    }
  }
}

int main() {
  std::string code;
  std::string line;
  std::cout << "Enter Code:\n";
  while (std::getline(std::cin, line) && line != "END") {
    code += line + "\n";
  }
  SymbolTable symbolTable;
  processCode(code, symbolTable);
  symbolTable.display();
  return 0;
}

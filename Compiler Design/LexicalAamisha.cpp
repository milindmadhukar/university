#include <cctype>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

class LexicalAnalyzer {
private:
    std::vector<std::string> keywords;
    std::vector<std::string> constants;
    std::vector<std::string> identifiers;
    std::vector<std::string> literals;
    std::vector<std::string> operators;
    std::vector<std::string> delimiters;

    bool isDelimiter(char ch) const {
        return (ch == ',' || ch == ';' || ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '"' || ch == '\'');
    }

    bool isOperator(char ch) const {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '>' || ch == '<' || ch == '=' || ch == '&' || ch == '|' || ch == '!' || ch == '^' || ch == '~');
    }

    bool isKeyword(const std::string& str) const {
        static const std::vector<std::string> keywordList = {
            "auto", "break", "case", "char", "const", "continue",
            "default", "do", "double", "else", "enum", "extern",
            "float", "for", "goto", "if", "int", "long", "register",
            "return", "short", "signed", "sizeof", "static", "struct",
            "switch", "typedef", "union", "unsigned", "void",
            "volatile", "while", "main", "print", "printf", "then", "endif"
        };
        return std::find(keywordList.begin(), keywordList.end(), str) != keywordList.end();
    }

    bool isInteger(const std::string& str) const {
        if (str.empty()) return false;
        size_t i = (str[0] == '-') ? 1 : 0;
        return str.find_first_not_of("0123456789", i) == std::string::npos;
    }

    bool isValidIdentifier(const std::string& str) const {
        if (str.empty() || std::isdigit(str[0]) || isKeyword(str)) return false;
        return std::all_of(str.begin(), str.end(), [](char c) { return std::isalnum(c) || c == '_'; });
    }

    void addToArray(std::vector<std::string>& arr, const std::string& value) {
        if (std::find(arr.begin(), arr.end(), value) == arr.end()) {
            arr.push_back(value);
        }
    }

    void categorizeToken(const std::string& token) {
        if (isKeyword(token)) {
            addToArray(keywords, token);
        } else if (isInteger(token)) {
            addToArray(constants, token);
        } else if (isValidIdentifier(token)) {
            addToArray(identifiers, token);
        } else {
            addToArray(literals, token);
        }
    }

public:
    void analyze(const std::string& input) {
        size_t left = 0, right = 0;
        while (right <= input.length()) {
            if (input[right] == ' ' || input[right] == '\0' || isDelimiter(input[right]) || isOperator(input[right])) {
                if (left != right) {
                    std::string token = input.substr(left, right - left);
                    categorizeToken(token);
                }
                if (isDelimiter(input[right])) {
                    addToArray(delimiters, std::string(1, input[right]));
                } else if (isOperator(input[right])) {
                    addToArray(operators, std::string(1, input[right]));
                }
                right++;
                left = right;
            } else {
                right++;
            }
        }
    }

    void printLexemes() const {
        auto printCategory = [](const std::vector<std::string>& lexemes, const std::string& type) {
            if (!lexemes.empty()) {
                std::cout << "Lexeme of " << type << ": ";
                for (const auto& lexeme : lexemes) {
                    std::cout << lexeme << " ";
                }
                std::cout << std::endl;
            }
        };

        printCategory(keywords, "keywords");
        printCategory(constants, "constants");
        printCategory(identifiers, "identifiers");
        printCategory(literals, "literals");
        printCategory(operators, "operators");
        printCategory(delimiters, "delimiters");
    }
};

int main() {
    std::string code;
    std::string line;
    std::cout << "Enter your code (type 'END' on a new line to finish):\n";
    while (std::getline(std::cin, line) && line != "END") {
        code += line + "\n";
    }

    LexicalAnalyzer analyzer;
    analyzer.analyze(code);
    analyzer.printLexemes();

    return 0;
}

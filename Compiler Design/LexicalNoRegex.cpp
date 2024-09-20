#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <cctype>

class LexicalAnalyzer {
private:
    std::vector<std::string> keywords;
    std::vector<std::string> identifiers;
    std::vector<std::string> operators;
    std::vector<std::string> delimiters;
    std::vector<std::string> stringLiterals;
    std::vector<std::string> numbers;

    std::unordered_set<std::string> keywordSet = {
        "auto", "break", "case", "char", "const", "continue", "default", "do",
        "double", "else", "enum", "extern", "float", "for", "goto", "if",
        "int", "long", "register", "return", "short", "signed", "sizeof", "static",
        "struct", "switch", "typedef", "union", "unsigned", "void", "volatile", "while"
    };

    std::unordered_set<char> operatorSet = {
        '+', '-', '*', '/', '%', '=', '!', '<', '>', '&', '|', '^', '~'
    };

    std::unordered_set<char> delimiterSet = {
        '(', ')', '{', '}', '[', ']', ';', ',', '.'
    };

    bool isOperatorChar(char c) {
        return operatorSet.find(c) != operatorSet.end();
    }

    bool isDelimiter(char c) {
        return delimiterSet.find(c) != delimiterSet.end();
    }

public:
    void analyze(const std::string& input) {
        std::string token;
        bool inString = false;
        bool inChar = false;
        bool inComment = false;
        char stringDelimiter;

        for (size_t i = 0; i < input.length(); ++i) {
            char c = input[i];

            if (inComment) {
                if (c == '*' && i + 1 < input.length() && input[i + 1] == '/') {
                    inComment = false;
                    ++i;
                }
                continue;
            }

            if (inString) {
                token += c;
                if (c == stringDelimiter && input[i - 1] != '\\') {
                    stringLiterals.push_back(token);
                    token.clear();
                    inString = false;
                }
                continue;
            }

            if (inChar) {
                token += c;
                if (c == '\'' && input[i - 1] != '\\') {
                    stringLiterals.push_back(token);
                    token.clear();
                    inChar = false;
                }
                continue;
            }

            if (c == '/' && i + 1 < input.length()) {
                if (input[i + 1] == '/') {
                    while (i < input.length() && input[i] != '\n') ++i;
                    continue;
                }
                if (input[i + 1] == '*') {
                    inComment = true;
                    ++i;
                    continue;
                }
            }

            if (c == '"' || c == '\'') {
                if (!token.empty()) {
                    classifyToken(token);
                    token.clear();
                }
                token += c;
                inString = (c == '"');
                inChar = (c == '\'');
                stringDelimiter = c;
                continue;
            }

            if (std::isspace(c)) {
                if (!token.empty()) {
                    classifyToken(token);
                    token.clear();
                }
                continue;
            }

            if (isOperatorChar(c) || isDelimiter(c)) {
                if (!token.empty()) {
                    classifyToken(token);
                    token.clear();
                }
                classifyToken(std::string(1, c));
                continue;
            }

            token += c;
        }

        if (!token.empty()) {
            classifyToken(token);
        }
    }

    void classifyToken(const std::string& token) {
        if (keywordSet.find(token) != keywordSet.end()) {
            keywords.push_back(token);
        } else if (std::isalpha(token[0]) || token[0] == '_') {
            identifiers.push_back(token);
        } else if (isOperatorChar(token[0])) {
            operators.push_back(token);
        } else if (isDelimiter(token[0])) {
            delimiters.push_back(token);
        } else if (token[0] == '"' || token[0] == '\'') {
            stringLiterals.push_back(token);
        } else if (std::isdigit(token[0]) || (token[0] == '.' && token.length() > 1 && std::isdigit(token[1]))) {
            numbers.push_back(token);
        }
    }

    void printTokens() {
        std::cout << "Keywords: ";
        for (const auto& keyword : keywords) std::cout << keyword << " ";
        std::cout << "\n\nIdentifiers: ";
        for (const auto& identifier : identifiers) std::cout << identifier << " ";
        std::cout << "\n\nOperators: ";
        for (const auto& op : operators) std::cout << op << " ";
        std::cout << "\n\nDelimiters: ";
        for (const auto& delimiter : delimiters) std::cout << delimiter << " ";
        std::cout << "\n\nString Literals: ";
        for (const auto& str : stringLiterals) std::cout << str << " ";
        std::cout << "\n\nNumbers: ";
        for (const auto& number : numbers) std::cout << number << " ";
        std::cout << "\n";
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
    analyzer.printTokens();

    return 0;
}

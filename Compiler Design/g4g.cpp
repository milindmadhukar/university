#include <iostream>
#include <vector>
#include <string>
#include <regex>
#include <unordered_set>

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

    std::unordered_set<std::string> operatorSet = {
        "+", "-", "*", "/", "%", "=", "==", "!=", "<", ">", "<=", ">=",
        "&&", "||", "!", "&", "|", "^", "~", "<<", ">>", "++", "--"
    };

    std::unordered_set<std::string> delimiterSet = {
        "(", ")", "{", "}", "[", "]", ";", ",", "."
    };

public:
    void analyze(const std::string& input) {
        std::regex tokenRegex(R"(//.*|/\*[\s\S]*?\*/|"(?:\\.|[^"\\])*"|'(?:\\.|[^'\\])*'|\b\d+(?:\.\d+)?\b|\b[a-zA-Z_]\w*\b|[+\-*/%=!<>&|^~]+|[(){}\[\];,.]|.)");
        std::sregex_iterator it(input.begin(), input.end(), tokenRegex);
        std::sregex_iterator end;

        while (it != end) {
            std::string token = it->str();
            classifyToken(token);
            ++it;
        }
    }

    void classifyToken(const std::string& token) {
        if (token.empty() || token[0] == ' ' || token[0] == '\n' || token[0] == '\t') {
            return;
        }
        if (token.substr(0, 2) == "//" || token.substr(0, 2) == "/*") {
            return; // Ignore comments
        }
        if (keywordSet.find(token) != keywordSet.end()) {
            keywords.push_back(token);
        } else if (std::regex_match(token, std::regex(R"([a-zA-Z_]\w*)"))) {
            identifiers.push_back(token);
        } else if (operatorSet.find(token) != operatorSet.end()) {
            operators.push_back(token);
        } else if (delimiterSet.find(token) != delimiterSet.end()) {
            delimiters.push_back(token);
        } else if (token[0] == '"' || token[0] == '\'') {
            stringLiterals.push_back(token);
        } else if (std::regex_match(token, std::regex(R"(\d+(?:\.\d+)?)"))) {
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
    std::string input = R"(
        int main() {
            int x = 10;
            float y = 3.14;
            std::string message = "Hello, World!";
            if (x > 5) {
                std::cout << message << std::endl;
            }
            return 0;
        }
    )";

    LexicalAnalyzer analyzer;
    analyzer.analyze(input);
    analyzer.printTokens();

    return 0;
}

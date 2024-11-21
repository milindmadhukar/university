#include <cctype>
#include <iostream>
#include <string>
#include <vector>

class ThreeAddressCodeGenerator {
private:
    std::string expression;
    size_t pos;
    int tempCounter;
    std::vector<std::string> code;

    char peek() {
        while (pos < expression.length() && std::isspace(expression[pos]))
            pos++;
        return (pos < expression.length()) ? expression[pos] : '\0';
    }

    char get() {
        char c = peek();
        if (c != '\0')
            pos++;
        return c;
    }

    std::string newTemp() { return "t" + std::to_string(++tempCounter); }

    void emit(const std::string &code) { this->code.push_back(code); }

    std::string factor() {
        if (peek() == '-') {
            get(); // consume '-'
            std::string operand = factor();
            std::string temp = newTemp();
            emit(temp + " = -" + operand);
            return temp;
        }
        if (std::isalnum(peek())) {
            return std::string(1, get());
        } else if (peek() == '(') {
            get(); // consume '('
            std::string result = expr();
            if (peek() == ')') {
                get(); // consume ')'
            } else {
                throw std::runtime_error("Mismatched parentheses");
            }
            return result;
        }
        throw std::runtime_error("Unexpected character");
    }

    std::string term() {
        std::string left = factor();
        while (peek() == '*' || peek() == '/') {
            char op = get();
            std::string right = factor();
            std::string temp = newTemp();
            emit(temp + " = " + left + " " + op + " " + right);
            left = temp;
        }
        return left;
    }

    std::string expr() {
        std::string left = term();
        while (peek() == '+' || peek() == '-') {
            char op = get();
            std::string right = term();
            std::string temp = newTemp();
            emit(temp + " = " + left + " " + op + " " + right);
            left = temp;
        }
        return left;
    }

    void assignment() {
        std::string left = std::string(1, get());
        if (get() != '=') {
            throw std::runtime_error("Expected '=' in assignment");
        }
        std::string right = expr();
        emit(left + " = " + right);
    }

    bool isAssignment() {
        size_t savedPos = pos;
        char c = peek();
        if (std::isalpha(c)) {
            get();
            if (peek() == '=') {
                pos = savedPos;
                return true;
            }
        }
        pos = savedPos;
        return false;
    }

public:
    ThreeAddressCodeGenerator() : pos(0), tempCounter(0) {}

    std::vector<std::string> generate(const std::string &inputExpression) {
        expression = inputExpression;
        pos = 0;
        tempCounter = 0;
        code.clear();
        
        if (isAssignment()) {
            assignment();
        } else {
            std::string result = expr();
            emit("result = " + result);
        }
        
        return code;
    }
};

int main() {
    ThreeAddressCodeGenerator generator;
    std::string inputExpression;

    std::cout << "Enter an expression: ";
    std::getline(std::cin, inputExpression);

    try {
        std::vector<std::string> threeAddressCode = generator.generate(inputExpression);

        std::cout << "\nThree-Address Code:\n";
        for (const auto &line : threeAddressCode) {
            std::cout << line << std::endl;
        }
    } catch (const std::exception &e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }

    return 0;
}

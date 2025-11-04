%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int yylex();
void yyerror(const char *s);

long long binary_to_decimal(const char *binary);
%}

%union {
    char *str;
}

%token <str> BINARY
%type <str> input

%%

program: 
    | program input
    ;

input: BINARY '\n' {
    long long decimal = binary_to_decimal($1);
    printf("Binary: %s\nDecimal: %lld\n\n", $1, decimal);
    free($1);
}
;

%%

long long binary_to_decimal(const char *binary) {
    long long decimal = 0;
    int length = strlen(binary);
    for (int i = 0; i < length; i++) {
        decimal = decimal * 2 + (binary[i] - '0');
    }
    return decimal;
}

void yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
}

int main() {
    printf("Enter binary numbers (Ctrl+D to exit):\n");
    yyparse();
    return 0;
}

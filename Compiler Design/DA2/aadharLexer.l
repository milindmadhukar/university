%{
#include <stdio.h>

void print_token(const char *token_type, const char *lexeme);
%}

%%
[0-9]{12}     { print_token("Valid Aadhaar Number", yytext); }
[0-9]{4}\ [0-9]{4}\ [0-9]{4}   { print_token("Valid Aadhaar Number", yytext); }
[0-9]+                       { print_token("Invalid Aadhaar Number", yytext); }
.                            { print_token("Invalid Aadhaar Number", yytext); }
%%

void print_token(const char *token_type, const char *lexeme) {
    printf("%s : %s\n", token_type, lexeme);
}

int main() {
    printf("Enter Aadhaar numbers (Ctrl+D to end input):\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}


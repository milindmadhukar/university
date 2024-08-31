%{
#include <stdio.h>

void print_token(const char *token_type, const char *lexeme);
%}

%%
([0-9A-Fa-f]{2}-){5}[0-9A-Fa-f]{2}    { print_token("Valid MAC Address", yytext); }
([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}    { print_token("Valid MAC Address", yytext); }
([0-9A-Fa-f]{4}\.){2}[0-9A-Fa-f]{4}      { print_token("Valid MAC Address", yytext); }
.                                        { print_token("Invalid MAC Address", yytext); }
%%

void print_token(const char *token_type, const char *lexeme) {
    printf("%s : %s\n", token_type, lexeme);
}

int main() {
    printf("Enter MAC addresses (Ctrl+D to end input):\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}

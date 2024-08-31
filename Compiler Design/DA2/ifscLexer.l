%{
#include <stdio.h>
#include <string.h>

void print_token(const char *token_type, const char *ifsc_code);
%}

%%
[A-Z]{4}0[A-Z0-9]{6}  { print_token("Valid IFSC Code", yytext); }
[A-Z0-9]+             { print_token("Invalid IFSC Code", yytext); }
.                     { print_token("Invalid IFSC Code", yytext); }
%%

void print_token(const char *token_type, const char *ifsc_code) {
    printf("%s: %s\n", token_type, ifsc_code);
}

int main() {
    printf("Enter IFSC codes (Ctrl+D to end input):\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}

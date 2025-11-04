%{
#include <stdio.h>
#include <string.h>

void print_token(const char *token_type, const char *number);
%}

%%
\+91[7-9][0-9]{9}        { print_token("Valid Mobile Number", yytext); }
0[7-9][0-9]{9}           { print_token("Valid Mobile Number", yytext); }
[7-9][0-9]{9}            { print_token("Valid Mobile Number", yytext); }
[0-9]+                   { print_token("Invalid Mobile Number", yytext); }
.                        { /* Ignore other invalid characters */ }
%%

void print_token(const char *token_type, const char *number) {
    printf("%s: %s\n", token_type, number);
}


int main() {
    printf("Enter mobile numbers (Ctrl+D to end input):\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}


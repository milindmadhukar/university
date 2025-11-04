%{
#include <stdio.h>
#include <string.h>

void print(const char *message, const char *text);
%}

%%
[A-Z]{4}0[A-Z0-9]{6}  { print("Valid IFSC Code", yytext); }
[A-Z0-9]+             { print("Invalid IFSC Code", yytext); }
.                     { print("Invalid IFSC Code", yytext); }
%%

void print(const char *message, const char *text) {
    printf("%s: %s\n", message, text);
}

int main() {
    printf("Enter IFSC codes (Ctrl+D to end input):\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}

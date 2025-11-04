%{
#include <stdio.h>

void print(const char *message, const char *text);
%}

%%
[0-9]{12}     { print("Valid Aadhaar Number", yytext); }
[0-9]{4}\ [0-9]{4}\ [0-9]{4}   { print("Valid Aadhaar Number", yytext); }
[0-9]+                       { print("Invalid Aadhaar Number", yytext); }
.                            { print("Invalid Aadhaar Number", yytext); }
%%

void print(const char *message, const char *text) {
    printf("%s : %s\n", message, text);
}

int main() {
    printf("Enter Aadhaar numbers (Ctrl+D to end input):\n");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}


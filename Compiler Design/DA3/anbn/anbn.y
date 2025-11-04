%{
#include <stdio.h>
#include <stdlib.h>

int yylex();
void yyerror(const char *s);
%}

%token A B NEWLINE INVALID

%%

start: 
    | start input
    ;

input: string NEWLINE {
    printf("Valid string: a^n b^n\n");
}
| INVALID NEWLINE {
    printf("Invalid string\n");
}
| error NEWLINE {
    yyerrok;
    printf("Invalid string\n");
}
;

string: /* empty */
    | A string B
    ;

%%

void yyerror(const char *s) {
    
}

int main() {
    printf("Enter strings to check if they match a^n b^n (n >= 0):\n");
    printf("(Press Ctrl+D to exit)\n");
    yyparse();
    return 0;
}

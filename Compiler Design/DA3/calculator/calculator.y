%{
#include <stdio.h>
#include <stdlib.h>

int yylex();
void yyerror(const char *s);
extern int yylineno;
int valid = 1;
%}

%token NUMBER

%left '+' '-'
%left '*' '/' '%'
%right UMINUS

%%

input: /* empty */
     | input line
     ;

line: '\n'         { /* ignore empty lines */ }
    | exp '\n'     { 
        if (valid) {
            printf("Result = %d\n", $1);
            printf("Entered arithmetic expression is Valid\n");
        } else {
            printf("Entered arithmetic expression is Invalid\n");
        }
        valid = 1;  // Reset for next expression
        printf("\n");  // Add a blank line for better readability
    }
    | error '\n'   { 
        yyerrok; 
        valid = 0;
        printf("Entered arithmetic expression is Invalid\n");
        printf("\n");  // Add a blank line for better readability
    }
    ;

exp: NUMBER
   | exp '+' exp       { $$ = $1 + $3; }
   | exp '-' exp       { $$ = $1 - $3; }
   | exp '*' exp       { $$ = $1 * $3; }
   | exp '/' exp       { 
        if ($3 == 0) {
            yyerror("Division by zero");
            valid = 0;
            $$ = 0;
        } else {
            $$ = $1 / $3;
        }
    }
   | exp '%' exp       { 
        if ($3 == 0) {
            yyerror("Modulo by zero");
            valid = 0;
            $$ = 0;
        } else {
            $$ = $1 % $3;
        }
    }
   | '-' exp %prec UMINUS { $$ = -$2; }
   | '(' exp ')'       { $$ = $2; }
   ;

%%

void yyerror(const char *s) {
    valid = 0;
}

int main() {
    printf("Enter arithmetic expressions (Ctrl+D to exit):\n");
    yyparse();
    return 0;
}

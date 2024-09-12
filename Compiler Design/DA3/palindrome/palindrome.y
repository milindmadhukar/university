%{
#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_LENGTH 1000
extern char input_string[MAX_LENGTH];
extern int input_length;

int yylex();
void yyerror(const char *s);

int is_palindrome();
%}

%token CHAR

%%

program: 
       | program input
       ;

input: string '\n' {
    if (is_palindrome()) {
        printf("Palindrome\n");
    } else {
        printf("Not a palindrome\n");
    }
    input_length = 0;
    memset(input_string, 0, MAX_LENGTH);
    fflush(stdout);
}
;

string:
      | string CHAR
      ;

%%

int is_palindrome() {
    if (input_length == 0) return 1;
    
    int i, j;
    for (i = 0, j = input_length - 1; i < j; i++, j--) {
        if (input_string[i] != input_string[j]) {
            return 0;
        }
    }
    return 1;
}

void yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
}

int main() {
    printf("Enter strings to check if they're palindromes:\n");
    yyparse();
    return 0;
}

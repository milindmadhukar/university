%{
#include <stdio.h>
#include <string.h>

void print_token(const char *token_type, const char *number);
%}

%%
"auto"|"break"|"case"|"char"|"const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extern"|"float"|"for"|"goto"|"if"|"inline"|"int"|"long"|"register"|"restrict"|"return"|"short"|"signed"|"sizeof"|"static"|"struct"|"switch"|"typedef"|"union"|"unsigned"|"void"|"volatile"|"while"    { print_token("keyword", yytext); }
[a-zA-Z_][a-zA-Z0-9_]*  { print_token("Identifier", yytext); }
"="|"+"|"-"|"*"|"/"     { print_token("operator", yytext); }
[0-9]+                  { print_token("Number", yytext); }
[ \t\n]                 { /* Ignore whitespace */ }
.                       { /* Ignore other invalid characters */ }
%%

void print_token(const char *token_type, const char *number) {
    printf("%s: %s\n", token_type, number);
}


int main(int argc, char **argv) {
  FILE *file;
  if (argc > 1) {
        file = fopen(argv[1], "r");
        if (!file) {
            perror(argv[1]);
            return 1;
        }
        yyin = file;
    }

    printf("All Tokens are:\n");
    yylex();
    fclose(file);

    return 0;
}

int yywrap() {
    return 1;
}


%{
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include "palindrome.tab.h"

#define MAX_LENGTH 1000
char input_string[MAX_LENGTH];
int input_length = 0;
%}

%%
[a-zA-Z]   { 
    if (input_length < MAX_LENGTH - 1) {
        input_string[input_length++] = tolower(yytext[0]);
    }
    return CHAR;
}
\n         { 
    input_string[input_length] = '\0'; 
    return '\n';
}
[ \t]      { /* Ignore whitespace */ }
.          { 
    return yytext[0];
}
%%

int yywrap() {
    return 1;
}

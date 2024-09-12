%{
#include "binary_to_decimal.tab.h"
#include <string.h>
%}

%%
[0-1]+      { yylval.str = strdup(yytext); return BINARY; }
\n          { return '\n'; }
[ \t]       { /* Ignore whitespace */ }
.           { printf("Invalid character: %s\n", yytext); }
%%

int yywrap() {
    return 1;
}

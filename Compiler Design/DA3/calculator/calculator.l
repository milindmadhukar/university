%{
#include <stdio.h>
#include "calculator.tab.h"
%}

%option yylineno

%%
[0-9]+      { yylval = atoi(yytext); return NUMBER; }
[-+*/%()]   { return yytext[0]; }
[ \t]       { /* ignore whitespace */ }
\n          { return '\n'; }
.           { /* ignore everything else */ }
%%

int yywrap() {
    return 1;
}

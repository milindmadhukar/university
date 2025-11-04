%{
#include "anbn.tab.h"
%}

%%
a       { return A; }
b       { return B; }
\n      { return NEWLINE; }
[ \t]   { /* Ignore whitespace */ }
.       { return INVALID; }
%%

int yywrap() {
    return 1;
}

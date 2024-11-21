%{
  #include <stdio.h>
  #include <string.h>
  void print(const char* type, const char* message);
%}

%%

^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$ { 
    print("Valid IP", yytext); 
}
^[^\n]+$ { 
    print("Invalid IP", yytext); 
}

%%

void print(const char* type, const char* message) {
  printf("%s - %s\n", type, message);
}

int main() {
  yylex();
  return 0;
}

int yywrap() {
  return 1;
}


bison -d anbn.y
flex anbn.l
gcc lex.yy.c anbn.tab.c -o anbn.out
./anbn.out

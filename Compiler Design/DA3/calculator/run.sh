#!/bin/bash

bison -d calculator.y
flex calculator.l
gcc lex.yy.c calculator.tab.c -o calculator.out
./calculator.out

#!/bin/bash

bison -d binary_to_decimal.y
flex binary_to_decimal.l
gcc lex.yy.c binary_to_decimal.tab.c -o binary_to_decimal.out
./binary_to_decimal.out

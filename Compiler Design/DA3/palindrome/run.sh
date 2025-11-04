#!/bin/bash

bison -d palindrome.y
flex palindrome.l
gcc lex.yy.c palindrome.tab.c -o palindrome.out
./palindrome.out

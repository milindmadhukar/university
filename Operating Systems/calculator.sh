#!/bin/bash

# shell script using case to create a simple arithmetic ccalculator using case statements
read -p "Enter the first number: " num1
read -p "Enter the second number: " num2

read -p "Enter the operator: " op

case $op in 
  "+")
    echo -n "$num1 $op $num2 = $((num1 + num2))"
    ;;

  "-")
    echo -n "$num1 $op $num2 = $((num1 - num2))"
    ;;

  "*")
    echo -n "$num1 $op $num2 = $((num1 * num2))"
    ;;

  "/")
    echo -n "$num1 $op $num2 = $((num1 / num2))"
    ;;
esac
echo

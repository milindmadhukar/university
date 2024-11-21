#!/bin/bash

read -p "Enter the first number: " num1
read -p "Enter the second number: " num2
read -p "Enter the operator (+, -, *, /): " op

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
        # Check for division by zero
        if [ "$num2" -eq 0 ]; then
            echo "Error: Division by zero is not allowed."
        else
            echo -n "$num1 $op $num2 = $((num1 / num2))"
        fi
        ;;
    *)
        echo "Invalid operator. Please use one of +, -, *, /."
        ;;
esac
echo


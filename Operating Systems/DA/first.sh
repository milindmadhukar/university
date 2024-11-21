#/!/bin/bash

counter=1

while [ $counter -le 5 ]; do
  echo "Number: $counter"
  ((counter++))
done

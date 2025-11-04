read -p "Enter rows: " rows
read -p "Enter columns: " columns

for (( i = 1; i <= $rows; i++ )); do
  for (( j = 1; j <= $columns; j++ )); do
    echo -n "$i * $j = $((i * j)) "
  done
  echo
done

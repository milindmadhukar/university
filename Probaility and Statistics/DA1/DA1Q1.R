# Problem 1: Create the following vectors in R.
# a = (5, 10, 15, 20,…, 160)
# b = (87, 86, 85,…, 56)
# Use vector arithmetic to multiply these vectors and call the result D. Select
# subsets of d to identifying the following
# i. What are the 19th, 20th, and 21st elements of d?
# ii. What are all of the elements of d which are less than 2000?

a <- seq(5, 160, 5)
b <- seq(87, 56, -1)

D <- a * b # nolint

nineteenth <- D[19]
twentieth <- D[20]
twentyfirst <- D[21]

print(nineteenth)
print(twentieth)
print(twentyfirst)

less_than_2000 <- D[D < 2000]
print(less_than_2000)

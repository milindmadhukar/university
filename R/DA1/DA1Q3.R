# Problem 3: Solve the following system of equations,
# if it has unique solution by
# matrix creation in R
# 20𝑥 + 𝑦 − 2𝑧 = 17, 3𝑥 + 20𝑦 − 𝑧 = −18, 2𝑥 − 3𝑦 + 20𝑧 = 25

eq1 <- function(x, y, z) {
  return(20 * x + y - 2 * z - 17)
}

eq2 <- function(x, y, z) {
  return(3 * x + 20 * y - z + 18)
}

eq3 <- function(x, y, z) {
  return(2 * x - 3 * y + 20 * z - 25)
}

## Solve the 3 equations

# Create the coefficient matrix
a <- matrix(c(20, 1, -2, 3, 20, -1, 2, -3, 20), nrow = 3, byrow = TRUE)

# Create the constant vector
b <- c(17, -18, 25)

# Solve the system of equations
solution <- solve(a, b)

print(solution)

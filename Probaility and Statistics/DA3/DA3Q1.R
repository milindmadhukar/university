# Problem 1: 1: In a certain factory turning out razor blades, there is small chance
# 0.001 for any blade to be defective. The blades are supplied in packets of 100.
# Write R code to calculate the approximate number of packets containing
# (i) no defective (ii) one defective and (iii) two defective blades respectively in a
# consignment of 10,000 packets. Also, how is distribution is distributed? Further,
# Sketch the probability function and cumulative distribution function
# (roughly). Furthermore, compute (a) variance of distribution and E(2X +51)

n <- 100
p <- 0.001
q <- 1 - p
# x0 is probability for no defective blades
x0 <- dbinom(0, n, p)
print(x0)

# x1 is the probability for exactly one defective blade
x1 <- dbinom(1, n, p)
print(x1)
consignment_size <- 10000
# x2 is the probability for 2 defective blades in a packet in a consignment of
# 1000 packets

x2 <- dbinom(2, n, p) * consignment_size
x2
# This distribution is a "BINOMIAL DISTRIBUTION"
x_values <- 0:n

plot(x_values, pbinom(x_values, n, p),
  type = "s", lwd = 2, col = "red",
  main = "Cumulative Distribution Function", xlab = "Number of Defective
Blades", ylab = "Cumulative Probability"
)

plot(x_values, dbinom(x_values, n, p),
  type = "h", lwd = 2, col = "blue",
  main = "Probability Mass Function", xlab = "Number of Defective Blades",
  ylab = "Probability"
)

# Variance of the binomial distribution
variance <- n * p * q
print("Variance")
print(variance)

# Expected value of 2X + 51
expected_value <- 2 * (n * p) + 51
print(expected_value)

print("Expected Value")
print(expected_value)

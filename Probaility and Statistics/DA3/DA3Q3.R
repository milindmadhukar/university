# Problem 3: In the production of corona masks, there is a chance that 20 out of
# 50 will be damaged. The masks are supplied in packets of 200. Compute the
# approximate number of packets containing (i) no damaged (ii) at least one is
# damaged and (iii) at most two will be damaged masks. Also, how is
# distribution is distributed? Further, Sketch the probability function and
# cumulative distribution function (roughly). Furthermore, compute (a)
# variance of distribution and E(3X -5).

N <- 200
n <- 50
p <- 20 / 50
compute_packets <- function(probability) {
  return(round(N * probability))
}
probability_no_damage <- dbinom(0, n, p)
packets_no_damage <- compute_packets(probability_no_damage)
probability_at_least_one_damage <- 1 - probability_no_damage
packets_at_least_one_damage <- N - packets_no_damage
probability_at_most_two_damage <- sum(dbinom(0:2, n, p))
packets_at_most_two_damage <-
  compute_packets(probability_at_most_two_damage)
variance <- n * p * (1 - p)
expected_value <- 3 * n * p - 5
# Output
cat("Number of packets with no damaged masks: ", packets_no_damage, "\n")
cat(
  "Number of packets with at least one damaged mask: ",
  packets_at_least_one_damage, "\n"
)
cat(
  "Number of packets with at most two damaged masks: ",
  packets_at_most_two_damage, "\n"
)
cat("Variance of the distribution: ", variance, "\n")
cat("E(3X - 5): ", expected_value, "\n")
# Plotting
x_values <- 0:n # Number of damaged masks
pmf <- dbinom(x_values, n, p)
cdf <- pbinom(x_values, n, p)
plot(x_values, pmf, type = "h", main = "Probability Function
(PMF)", xlab = "Number of Damaged Masks", ylab = "Probability")
plot(x_values, cdf,
  type = "s", main = "Cumulative Distribution Function (CDF)",
  xlab = "Number of Damaged Masks", ylab = "Cumulative Probability"
)

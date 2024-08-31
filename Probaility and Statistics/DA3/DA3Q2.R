observed <- c(0, 1, 2, 3, 4, 5)

frequency <- c(1, 10, 24, 35, 18, 8)

total_trials <- sum(frequency)

binomial_expected <- dbinom(observed, size = 5, prob = 0.5) * total_trials

lambda <- 5 * 0.5

poisson_expected <- dpois(observed, lambda) * total_trials

par(mar = c(5, 5, 4, 2) + 0.1)
plot(observed, frequency,
  type = "o", col = "blue", ylim = c(0, max(frequency)),
  xlab = "No. of dice showing 4, 5, or 6", ylab = "Frequency", main =
    "Experimental vs. Expected Distribution"
)
lines(observed, binomial_expected, type = "o", col = "red")
lines(observed, poisson_expected, type = "o", col = "green")

legend("topright",
  legend = c("Experimental", "Binomial", "Poisson"), col =
    c("blue", "red", "green"), pch = c(1, 1, 1)
)

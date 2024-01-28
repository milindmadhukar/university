# Problem 5: The following table shows the marks obtained by 90 candidates in an
# examination.
#
# Marks             20-29 30-39 40-49 50-59 60-69 70-79 80-89 90-99.
# No. of candidates   5     12    15    20    18    10    6     4
#
# a) Calculate the mean, median, and mode of the distribution using R.
# b) Use R to find quartile range, standard deviation,
# and coefficient of variation.
# b) Use R to find the first four central moments
# of the distribution to talk about
# skewness and kurtosis of the distribution.
# c) Plot the curve of the given distribution
# and discuss the nature of the curve in
# terms of Skewness and kurtosis.

mid <- seq(24.5, 94.5, 10)
f <- c(5, 12, 15, 20, 18, 10, 6, 4)
cf <- cumsum(f)

data <- data.frame(mid, f, cf)

mean_marks <- sum(mid * f) / sum(f)
print(paste("Mean marks:", mean_marks))

n <- sum(f)
# To identify median class with N/2 value
ml <- min(which(cf >= n / 2))

h <- ml
fr <- f[ml]
c <- cf[ml - 1]
l <- mid[ml] - h / 2

median_marks <- l + (((n / 2) - c) / fr) * h
print(paste("Median marks:", median_marks))


m <- which(f == max(f))
fm <- f[m]
f1 <- f[m - 1]
f2 <- f[m + 1]
l <- mid[m] - h / 2

mode_marks <- l + ((fm - f1) / ((fm - f1) + (fm - f2))) * h
print(paste("Mode marks:", mode_marks))



q1 <- median_marks - (h / 2) * ((n / 4) - c) / f[ml - 1]
q3 <- median_marks + (h / 2) * ((3 * n / 4) - c) / f[ml + 1]
print(paste("Quartile range:", q3 - q1))

sd <- sqrt(sum((mid - mean_marks)^2 * f) / (n - 1))
print(paste("Standard deviation:", sd))

cov <- sd / mean_marks * 100
print(paste("Coefficient of variation:", cov))

m1 <- sum((mid - mean_marks)^1 * f) / n
print(paste("First moment:", m1))

m2 <- sum((mid - mean_marks)^2 * f) / n
print(paste("Second moment:", m2))

m3 <- sum((mid - mean_marks)^3 * f) / n
print(paste("Third moment:", m3))

m4 <- sum((mid - mean_marks)^4 * f) / n
print(paste("Fourth moment:", m4))

skewness <- m3 / sd^3
print(paste("Skewness:", skewness))

kurtosis <- m4 / sd^4
print(paste("Kurtosis:", kurtosis))

plot(mid, f,
  type = "h", lwd = 2,
  col = "blue",
  xlab = "Marks",
  ylab = "Frequency"
)

# Looks like a normal distribution

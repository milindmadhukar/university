x <- c(1, 1, 2, 2, 3, 3, 4, 5, 6, 7)
y <- c(2, 7, 7, 10, 8, 12, 10, 14, 11, 14)

linear_model <- lm(y ~ x)
print(summary(linear_model))

correlation_coefficient <- cor(x, y)

print(correlation_coefficient)

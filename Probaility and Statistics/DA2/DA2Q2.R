# For 10 randomly selected observations, the following data were
# recorded:
# Write down R code to find the linear regression lines between
# Overtime hrs. (x) and additional units (y).
# Comment on the correlation coefficient.

x <- c(1, 1, 2, 2, 3, 3, 4, 5, 6, 7)
y <- c(2, 7, 7, 10, 8, 12, 10, 14, 11, 14)

linear_model <- lm(y ~ x)
print(summary(linear_model))

r <- cor(x, y)

print(r)

plot(x,y, main="Overtime vs. Additional Units",xlab="Overtime(in hrs)",
     ylab="additional units",col="red")

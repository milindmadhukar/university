mine1 <- c(8260, 8130, 8350, 8070, 8340)
mine2 <- c(7950, 7890, 7900, 8140, 7920, 7840)
var.test(mine1, mine2)

# HO: The variance of the heat-producing capacity of coal
# specimens from mine 1 is equal to the variance
# of the heat-producing capacity of coal specimens from mine 2.
# Since p-value is greater than 0.01
# and greater than 0.05 we fail to reject
# the null hypothesis and may say that the variances are equal.

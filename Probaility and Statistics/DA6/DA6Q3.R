observed <- matrix(c(86, 60, 44, 10, 40, 33, 25, 2), nrow = 2, byrow = TRUE)
total <- c(200, 100)
expected <- outer(rowSums(observed), colSums(observed)) / sum(total)
chisq.test(observed, expected)

# HO: here is no significant association
# between the researcher and the intelligence level.
# At 1% LOS, p-value is greater than 0.01.
# Therefore we fail to reject the null hypothesis which me ans that there is
# no significant difference in the sampling
# techniques adopted by the two researcher
# At 5% LOS, p-value is greater than 0.05.
# Therefore we fail to reject the null hypothesis
# which me ans that there is no significant difference
# in the sampling techniques adopted by the two researcher

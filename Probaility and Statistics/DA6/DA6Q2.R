observed <- c(46, 68, 62, 200 - 46 - 68 - 62)
total_observed <- sum(observed)
expected <- total_observed * c(4, 3, 2, 1) / sum(c(4, 3, 2, 1))
chisq.test(observed, expected)

# HO: The observed distribution of examination results among
# MBA students is commensurate with the general examination result ratios.
# At 1% LOS, p-value is greater than 0.01.
# Therefore we fail to reject the null hypothesis which means
# that the observed distribution differs significantly
# from the expected distribution.
# At 5% LOS, p-value ws greater than 0.05.
# Therefore we fail to reject the null hypothesis
# which means that the observed distribution differs
# significantly from the expected distribution.

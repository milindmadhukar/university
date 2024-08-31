# Data
mean_company <- 647
sd_company <- 27
n_company <- 40

mean_competitor <- 638
sd_competitor <- 31
n_competitor <- 40

# Degrees of freedom
df <- n_company + n_competitor - 2

# Calculate pooled standard deviation
pooled_sd <- sqrt(((n_company - 1) * sd_company^2 + (n_competitor - 1) * sd_competitor^2)
                  / df)

# Calculate t-statistic
t_statistic <- (mean_company - mean_competitor) / (pooled_sd * sqrt(1/n_company +
                                                                    1/n_competitor))

# Calculate p-value
p_value <- 2 * pt(-abs(t_statistic), df)

# Confidence intervals
margin_of_error <- qt(0.995, df) * pooled_sd * sqrt(1/n_company + 1/n_competitor)
ci_lower <- (mean_company - mean_competitor) - margin_of_error
ci_upper <- (mean_company - mean_competitor) + margin_of_error

# Print results
cat("t-statistic:", t_statistic, "\n")
cat("p-value:", p_value, "\n")
cat("Confidence Interval (99%): [", ci_lower, ",", ci_upper, "]\n")


# Check significance at 1% level
if (p_value < 0.01) {
 cat("The difference is significant at the 1% level.\n")
} else {
 cat("The difference is not significant at the 1% level.\n")
}

# Check significance at 5% level
if (p_value < 0.05) {
 cat("The difference is significant at the 5% level.\n")
} else {
 cat("The difference is not significant at the 5% level.\n")
}
sample_mean <- 9
population_mean <- 10
n <- 36
sample_variance <- 16
# Calculate the standard error
standard_error <- sqrt(sample_variance / n)

# Calculate the t-statistic
t_statistic <- (sample_mean - population_mean) / standard_error
# Calculate the degrees of freedom
df <- n - 1
# Calculate the critical t-value at 0.05 significance level
critical_t <- qt(0.05, df)
# Perform the one-sample t-test
p_value <- pt(t_statistic, df)

# Print the results
cat("t-statistic:", t_statistic, "\n")
cat("p-value:", p_value, "\n")
cat("Critical t-value:", critical_t, "\n")

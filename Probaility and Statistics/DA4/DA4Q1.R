mean_marks <- 78
sd_marks <- 11
above_90 <- pnorm(90,
  mean = mean_marks,
  sd = sd_marks,
  lower.tail = FALSE
) * 1000

print(round(above_90))
print(above_90)

lowest_10 <- qnorm(0.1, mean = mean_marks, sd = sd_marks)

print(round(lowest_10))
print(lowest_10)

middle_90 <- quantile(rnorm(1000, mean_marks, sd_marks), c(0.05, 0.95))
print(middle_90)

print(round(middle_90[1]))

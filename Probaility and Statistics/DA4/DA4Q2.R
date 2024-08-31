mean_weight <- 70
sd_weight <- 12
weight_82 <- dnorm(82, mean = mean_weight, sd = sd_weight) * 600
round(weight_82)

x <- seq(40, 100, length.out = 1000)
y <- dnorm(x, mean = mean_weight, sd = sd_weight)
plot(x, y, type = "l", main = "Density Plot of Weight Distribution")
abline(v = 82, col = "red")

between_65_88 <- diff(
  pnorm(c(65, 88),
    mean = mean_weight,
    sd = sd_weight
  )
) * 600
print(round(between_65_88))
plot(x, y, type = "l", main = "Density Plot of Weight Distribution")

polygon(
  c(65, seq(65, 88, length.out = 100), 88),
  c(0, dnorm(seq(65, 88, length.out = 100),
    mean = mean_weight, sd = sd_weight
  ), 0),
  col = "skyblue"
)

polygon(c(65, seq(65, 88, length.out = 100), 88),
  c(0, dnorm(seq(65, 88, length.out = 100),
    mean = mean_weight, sd = sd_weight
  ), 0),
  col = "skyblue"
)

greater_than_90 <- (1 - pnorm(90, mean = mean_weight, sd = sd_weight)) * 600
print(round(greater_than_90))

plot(x, y, type = "l", main = "Density Plot of Weight Distribution")

polygon(
  c(90, seq(90, 100, length.out = 100)),
  c(0, dnorm(seq(90, 100, length.out = 100),
    mean = mean_weight, sd = sd_weight
  )),
  col = "pink"
)
less_than_75 <- pnorm(75, mean = mean_weight, sd = sd_weight) * 600
print(round(less_than_75))

plot(x, y, type = "l", main = "Density Plot of Weight Distribution")

polygon(
  c(seq(40, 75, length.out = 100), 75),
  c(dnorm(seq(40, 75, length.out = 100),
    mean = mean_weight, sd = sd_weight
  ), 0),
  col = "lightgreen"
)

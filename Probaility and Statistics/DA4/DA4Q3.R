x1 <- 67.85
x2 <- 68.55
mu1 <- 0
mu2 <- 0
n1 <- 6400
n2 <- 1600
sig1 <- 2.56
sig2 <- 2.52
num <- x1 - x2 - (mu1 - mu2)
den <- sqrt(((sig1 * sig1) / n1) + ((sig2 * sig2) / n2))
z_cal <- num / den
print(z_cal)

alpha <- 0.01
z.alpha <- qnorm(1 - alpha)
print(z.alpha)

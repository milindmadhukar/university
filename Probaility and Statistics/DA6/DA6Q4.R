n <- 7 # DEGREE OF FREEDOM
N <- 128
P <- 0.5 # probability of getting head
x <- c(0, 1, 2, 3, 4, 5, 6, 7)
obf <- c(7, 6, 19, 36, 30, 23, 7, 1)
exf <- dbinom(x, n, P) * 128
print(sum(obf))
print(sum(exf))

chisq <- sum((obf - exf)^2 / exf) # CALCULATED VALUE

qchisq(0.99, 7) # at 1%los
qchisq(0.95, 7) # at 5% los

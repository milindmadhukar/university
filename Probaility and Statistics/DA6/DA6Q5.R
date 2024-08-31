x <- 0:6
f <- c(275, 72, 30, 7, 5, 2, 1)

lambda <- 0.4

lambda <- dpois(x, lambda) * sum(f)
exf <- dpois(x, lambda) * sum(f)

f1 <- round(exf)

sum(f)
sum(f1)

obf <- c(275, 72, 30, 15)
exf <- c(242, 117, 28, 6)
chisq <- sum((obf - exf)^2 / exf)
print(chisq)

qchisq(0.95, 2)

biology <- c(2, 4, 1, 5, 3, 6)
social <- c(5, 6, 2, 3, 4, 1)
zoology <- c(3, 4, 5, 6, 1, 2)

r_bs <- cor(biology, social)
r_bz <- cor(biology, zoology)
r_sz <- cor(social, zoology)

print(
  max(
    r_bs,
    r_bz,
    r_sz
  )
)

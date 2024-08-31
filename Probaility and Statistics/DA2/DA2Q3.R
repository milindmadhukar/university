# Suppose we have ranks of 6 students in three subject’s biology, social
# and zoology. Find which two subjects have the same trend.

biology <- c(2, 4, 1, 5, 3, 6)
social <- c(5, 6, 2, 3, 4, 1)
zoology <- c(3, 4, 5, 6, 1, 2)

r_bs <- cor(biology, social)
print(r_bs)
r_bz <- cor(biology, zoology)
print(r_bz)
r_sz <- cor(social, zoology)
print(r_sz)

print(max(r_bs, r_bz, r_sz))

p = 19
g = 10

d = 16
e = pow(g, d, p)

alice_public_key = (p, g, e)

m = 14

# Choose k such that coprime with p-1
k = 5

S1 = pow(g, k, p)

Kinv = 1
while (Kinv * k) % (p - 1) != 1:
    Kinv += 1

S2 = Kinv * (m - d * S1) % (p - 1)

print("(S1, S2)", (S1, S2))

# Verifying
v1 = pow(g, m, p)
v2 = (pow(e, S1) * pow(S1, S2)) % p

print("(v1, v2)", (v1, v2), v1 == v2)

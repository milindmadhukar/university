p = 353
g = 3

values = []
for i in range(p):
    values.append(pow(g, i, p))
if len(set(values)) != p - 1:
    print("q is not a primitive root")
    exit(1)

a = 97
b = 233

print("Alice Private Key", a)
print("Bob Private Key", b)

A = pow(g, a, p)
print("Alice Public Key", A)

B = pow(g, b, p)
print("Bob Public Key", B)

# Shared key K1
K1 = pow(B, a, p)
K2 = pow(A, b, p)

print("(K1, K2)", (K1, K2), K1 == K2)


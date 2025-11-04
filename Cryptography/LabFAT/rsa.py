# Get two prime numbers

p = 5
q = 11
n = p * q

phi = (p - 1) * (q - 1)

# 1 to phi and gcd(e, phi) = 1
e = 7

d = 1
while (e*d) % phi != 1:
    d += 1

M = 2

public_key = (e, n)
private_key = (d, n)

print("Public Key", public_key)
print("Private Key", private_key)

E = pow(M, *public_key)
print("Encrypted text", E)

D = pow(E, *private_key)
print("Decrypted text", D)

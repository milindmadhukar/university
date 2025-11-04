import random
from hashlib import sha256
from math import gcd

# Utility: GCD
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# Utility: Modular inverse
def modinv(a, m):
    m0, x0, x1 = m, 0, 1
    if m == 1:
        return 0
    while a > 1:
        q = a // m
        a, m = m, a % m
        x0, x1 = x1 - q * x0, x0
    return x1 + m0 if x1 < 0 else x1

# Find primitive root (your original method)
def find_primitive_root(p):
    required_set = set(num for num in range(1, p) if gcd(num, p) == 1)
    for g in range(2, p):
        actual_set = set(pow(g, powers, p) for powers in range(1, p))
        if required_set == actual_set:
            return g
    return None

# Public parameters
p = 467  # Small prime for demo (use larger in practice)
g = find_primitive_root(p)
if g is None:
    raise ValueError(f"No primitive root found for p = {p}")
print(f"Public parameters:\n  Prime (p): {p}\n  Primitive Root (g): {g}")

# Key generation
def generate_keys():
    x = random.randint(1, p - 2)  # Private key
    y = pow(g, x, p)              # Public key
    return (p, g, y), x

# Hash function
def hash_message(msg):
    return int(sha256(msg.encode()).hexdigest(), 16) % p

# Signing
def sign(message, private_key):
    h = hash_message(message)
    while True:
        k = random.randint(1, p - 2)
        if gcd(k, p - 1) == 1:
            break
    r = pow(g, k, p)
    k_inv = modinv(k, p - 1)
    s = (k_inv * (h - private_key * r)) % (p - 1)
    return (r, s)

# Verification
def verify(message, signature, public_key):
    r, s = signature
    h = hash_message(message)
    p, g, y = public_key
    if not (0 < r < p):
        return False
    v1 = (pow(y, r, p) * pow(r, s, p)) % p
    v2 = pow(g, h, p)
    return v1 == v2

# Example usage
public_key, private_key = generate_keys()
msg = "ElGamal Signature Test"
signature = sign(msg, private_key)

print(f"Public Key (p, g, y): {public_key}")
print(f"Private Key (x): {private_key}")
print(f"Message: {msg}")
print(f"Signature (r, s): {signature}")
print("✅ Signature valid!" if verify(msg, signature, public_key) else "❌ Invalid!")
import random

# Greatest Common Divisor
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# Function to find a primitive root modulo p
def find_primitive_root(p):
    required_set = set(num for num in range(1, p) if gcd(num, p) == 1)
    for g in range(2, p):
        actual_set = set(pow(g, powers, p) for powers in range(1, p))
        if required_set == actual_set:
            return g
    return None

# Diffie-Hellman Key Exchange
def diffie_hellman():
    # Prime number
    p = 23  # Small prime for demonstration

    # Find primitive root g
    g = find_primitive_root(p)
    if g is None:
        raise ValueError(f"No primitive root found for p = {p}")

    print(f"Public parameters:\n  Prime (p): {p}\n  Primitive Root (g): {g}")

    # Alice's private and public key
    a = random.randint(1, p - 2)
    A = pow(g, a, p)

    # Bob's private and public key
    b = random.randint(1, p - 2)
    B = pow(g, b, p)

    print(f"Alice's public key (A): {A}")
    print(f"Bob's public key (B): {B}")

    # Shared secrets
    shared_secret_alice = pow(B, a, p)
    shared_secret_bob = pow(A, b, p)

    print(f"Alice's computed shared secret: {shared_secret_alice}")
    print(f"Bob's computed shared secret: {shared_secret_bob}")

    assert shared_secret_alice == shared_secret_bob
    return shared_secret_alice

# Run it
shared_key = diffie_hellman()
print(f"\n✅ Shared secret key established: {shared_key}")

import random
from math import gcd

# Function to find modular inverse using Extended Euclidean Algorithm
def modinv(a, m):
    m0, x0, x1 = m, 0, 1
    if m == 1:
        return 0
    while a > 1:
        q = a // m
        a, m = m, a % m
        x0, x1 = x1 - q * x0, x0
    return x1 + m0 if x1 < 0 else x1

# Function to check for prime
def is_prime(n):
    if n <= 1:
        return False
    if n <= 3:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i+2) == 0:
            return False
        i += 6
    return True

# Generate a small random prime
def generate_prime(start=100, end=300):
    while True:
        num = random.randint(start, end)
        if is_prime(num):
            return num

# RSA Key Generation
def generate_keys():
    p = generate_prime()
    q = generate_prime()
    while p == q:
        q = generate_prime()

    n = p * q
    phi = (p - 1) * (q - 1)

    # Choose e
    e = 65537  # Common choice
    while gcd(e, phi) != 1:
        e = random.randint(2, phi - 1)

    # Compute d
    d = modinv(e, phi)

    # Public and private keys
    public_key = (e, n)
    private_key = (d, n)

    return public_key, private_key

# Encrypt a message
def encrypt(message, public_key):
    e, n = public_key
    cipher = [pow(ord(char), e, n) for char in message]
    return cipher

# Decrypt a message
def decrypt(ciphertext, private_key):
    d, n = private_key
    message = ''.join([chr(pow(char, d, n)) for char in ciphertext])
    return message

# Example Usage
public_key, private_key = generate_keys()

message = input("Enter a message to encrypt: ")
print("Original message:", message)

encrypted = encrypt(message, public_key)
print("Encrypted message:", encrypted)

decrypted = decrypt(encrypted, private_key)
print("Decrypted message:", decrypted)


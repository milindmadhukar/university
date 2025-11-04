'''
22BCE2747
Milind Madhukar
'''

def egcd(a, b):
    if b == 0:
        return (a, 1, 0)
    else:
        g, x1, y1 = egcd(b, a % b)
        return (g, y1, x1 - (a // b) * y1)

def modinv(a, m):
    g, x, _ = egcd(a, m)
    if g != 1:
        raise Exception("Modular inverse does not exist for a = {} modulo m = {}".format(a, m))
    return x % m

def modexp(base, exp, mod):
    result = 1
    base = base % mod
    while exp > 0:
        if exp % 2 == 1:
            result = (result * base) % mod
        exp //= 2
        base = (base * base) % mod
    return result

def simple_hash(message):
    return sum(ord(ch) for ch in message)

def dsa_signature():
    p = 47
    q = 23
    h = 5
    exponent = (p - 1) // q
    g = modexp(h, exponent, p)
    print("DSA parameters: p = {}, q = {}, g = {}".format(p, q, g))
    x = 3
    y = modexp(g, x, p)
    print("DSA Private key x: {}".format(x))
    print("DSA Public key y: {}".format(y))

    message = input("Enter a message to sign: ")

    hash_m = simple_hash(message) % q
    print("Message hash (mod {}): {}".format(q, hash_m))

    k = 2
    r = modexp(g, k, p) % q
    if r == 0:
        raise Exception("r is 0, choose a different k!")
    k_inv = modinv(k, q)
    s = (k_inv * (hash_m + x * r)) % q
    if s == 0:
        raise Exception("s is 0, choose a different k!")
    

    print("DSA Signature: (r, s) = ({}, {})".format(r, s))

    w = modinv(s, q)
    u1 = (hash_m * w) % q
    u2 = (r * w) % q
    v = ( (modexp(g, u1, p) * modexp(y, u2, p)) % p ) % q
    print("Computed v: {}".format(v))
    
    if v == r:
        print("DSA Verification: SUCCESS")
    else:
        print("DSA Verification: FAILURE")

if __name__ == "__main__":
    dsa_signature()

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

def rsa_signature():
    p = 61
    q = 53
    n = p * q
    phi = (p - 1) * (q - 1)

    e = 17

    d = modinv(e, phi)

    print("RSA Public key (n, e): ({}, {})".format(n, e))
    print("RSA Private key d: {}".format(d))

    message = input("Enter a message to sign: ")
    
    hash_m = simple_hash(message) % n
    print("Message hash (mod {}): {}".format(n, hash_m))

    signature = modexp(hash_m, d, n)
    print("RSA Signature: {}".format(signature))

    verified_hash = modexp(signature, e, n)
    print("Verified hash: {}".format(verified_hash))
    if verified_hash == hash_m:
        print("RSA Verification: SUCCESS")
    else:
        print("RSA Verification: FAILURE")


if __name__ == "__main__":
    rsa_signature()


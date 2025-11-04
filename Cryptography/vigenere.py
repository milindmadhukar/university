'''
Milind Madhukar
22BCE2747
'''

def repeat_key(key, length):
    return (key * (length // len(key))) + key[:length % len(key)]

def vigenere_encrypt(plaintext, key):
    key = repeat_key(key, len(plaintext))
    ciphertext = ""
    for p, k in zip(plaintext, key):
        encrypted_char = chr(((ord(p) - ord('A') + (ord(k) - ord('A'))) % 26) + ord('A'))
        ciphertext += encrypted_char
    return ciphertext

def vigenere_decrypt(ciphertext, key):
    key = repeat_key(key, len(ciphertext))
    plaintext = ""
    for c, k in zip(ciphertext, key):
        decrypted_char = chr(((ord(c) - ord('A') - (ord(k) - ord('A'))) % 26) + ord('A'))
        plaintext += decrypted_char
    return plaintext

def main():
    plaintext = input("Enter the plaintext (uppercase letters only): ").replace(" ", "").upper()
    key = input("Enter the key (uppercase letters only): ").replace(" ", "").upper()
    
    ciphertext = vigenere_encrypt(plaintext, key)
    print("Ciphertext:", ciphertext)
    
    decrypted_text = vigenere_decrypt(ciphertext, key)
    print("Decrypted Text:", decrypted_text)
    
if __name__ == "__main__":
    main()

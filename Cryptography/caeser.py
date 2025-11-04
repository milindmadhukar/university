'''
Milind Madhukar
22BCE2747
'''

def caeser_encrypt(text: str, shift: int) -> str:
    encrypted_text = ""
    for char in text:
        if char.isalpha():
            ascii_offset = 65 if char.isupper() else 97
            encrypted_text += chr((ord(char) - ascii_offset + shift) % 26 + ascii_offset)
        else:
            encrypted_text += char
    return encrypted_text

def caeser_decrypt(text: str, shift: int) -> str:
    return caeser_encrypt(text, -shift)

if __name__ == "__main__":
    text = input("Enter text to encrypt: ")
    shift = int(input("Enter shift: "))
    encrypted_text = caeser_encrypt(text, shift)

    print(f"Encrypted text: {encrypted_text}")

    text = input("Enter text to decrypt: ")
    shift = int(input("Enter shift: "))
    decrypted_text = caeser_decrypt(text, shift)

    print(f"Decrypted text: {decrypted_text}")

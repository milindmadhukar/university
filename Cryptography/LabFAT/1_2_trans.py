import math

# Clean input (remove spaces, uppercase)
def clean_text(text):
    return ''.join(text.upper().split())

# Get numeric order of the key
def get_key_order(key):
    return sorted(range(len(key)), key=lambda k: key[k])

# Encrypt
def row_transposition_encrypt(plaintext, key):
    plaintext = clean_text(plaintext)
    key_order = get_key_order(key)
    num_cols = len(key)
    num_rows = math.ceil(len(plaintext) / num_cols)

    # Fill matrix row by row
    matrix = [['' for _ in range(num_cols)] for _ in range(num_rows)]
    index = 0
    for r in range(num_rows):
        for c in range(num_cols):
            if index < len(plaintext):
                matrix[r][c] = plaintext[index]
                index += 1
            else:
                matrix[r][c] = 'X'  # Padding

    # Read columns in key order
    ciphertext = ''
    for c in key_order:
        for r in range(num_rows):
            ciphertext += matrix[r][c]
    return ciphertext

# Decrypt
def row_transposition_decrypt(ciphertext, key):
    ciphertext = clean_text(ciphertext)
    key_order = get_key_order(key)
    num_cols = len(key)
    num_rows = math.ceil(len(ciphertext) / num_cols)

    # Prepare empty matrix
    matrix = [['' for _ in range(num_cols)] for _ in range(num_rows)]

    # Fill columns in order
    index = 0
    for k_index in key_order:
        for r in range(num_rows):
            if index < len(ciphertext):
                matrix[r][k_index] = ciphertext[index]
                index += 1

    # Read row by row
    plaintext = ''
    for r in range(num_rows):
        for c in range(num_cols):
            plaintext += matrix[r][c]
    return plaintext

# Example usage
if __name__ == "__main__":
    key = "4312567"  # Key can be string of digits or characters
    plaintext = "WE ARE DISCOVERED RUN"
    print("Plaintext:", plaintext)

    encrypted = row_transposition_encrypt(plaintext, key)
    print("Encrypted:", encrypted)

    decrypted = row_transposition_decrypt(encrypted, key)
    print("Decrypted:", decrypted)

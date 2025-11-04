'''
Milind Madhukar
22BCE2747
'''

def create_matrix(key):
    matrix = [['' for _ in range(5)] for _ in range(5)]
    key = ''.join(dict.fromkeys(key.upper()))
    alphabet = ''.join(dict.fromkeys('ABCDEFGHIKLMNOPQRSTUVWXYZ'))
    full_key = key + ''.join(c for c in alphabet if c not in key)
    for i in range(5):
        for j in range(5):
            matrix[i][j] = full_key[i * 5 + j]
            
    return matrix

def find_position(matrix, char):
    if char == 'J':
        char = 'I'
    
    for i in range(5):
        for j in range(5):
            if matrix[i][j] == char:
                return i, j
    return None

def prepare_text(text):
    text = ''.join(c for c in text.upper() if c.isalpha())
    text = text.replace('J', 'I')
    
    processed = []
    i = 0
    while i < len(text):
        if i == len(text) - 1:
            processed.append(text[i] + 'X')
            i += 1
        elif text[i] == text[i + 1]:
            processed.append(text[i] + 'X')
            i += 1
        else:
            processed.append(text[i] + text[i + 1])
            i += 2
            
    return processed

def encrypt(plain_text, key):
    matrix = create_matrix(key)
    pairs = prepare_text(plain_text)
    cipher_text = ''
    
    for pair in pairs:
        row1, col1 = find_position(matrix, pair[0])
        row2, col2 = find_position(matrix, pair[1])
        
        if row1 == row2:  # Same row
            cipher_text += matrix[row1][(col1 + 1) % 5] + matrix[row2][(col2 + 1) % 5]
        elif col1 == col2:  # Same column
            cipher_text += matrix[(row1 + 1) % 5][col1] + matrix[(row2 + 1) % 5][col2]
        else:  # Rectangle case
            cipher_text += matrix[row1][col2] + matrix[row2][col1]
            
    return cipher_text

def decrypt(cipher_text, key):
    matrix = create_matrix(key)
    pairs = [cipher_text[i:i+2] for i in range(0, len(cipher_text), 2)]
    plain_text = ''
    
    for pair in pairs:
        row1, col1 = find_position(matrix, pair[0])
        row2, col2 = find_position(matrix, pair[1])
        
        if row1 == row2:  # Same row
            plain_text += matrix[row1][(col1 - 1) % 5] + matrix[row2][(col2 - 1) % 5]
        elif col1 == col2:  # Same column
            plain_text += matrix[(row1 - 1) % 5][col1] + matrix[(row2 - 1) % 5][col2]
        else:  # Rectangle case
            plain_text += matrix[row1][col2] + matrix[row2][col1]
    
    # Remove padding X's at the end if present
    if plain_text.endswith('X'):
        plain_text = plain_text[:-1]
            
    return plain_text

if __name__ == "__main__":
    key = input("Enter key for encryption: ")
    plaintext = input("Enter plaintext: ")
    
    # Encrypt
    encrypted = encrypt(plaintext, key)
    print(f"Original: {plaintext}")
    print(f"Encrypted: {encrypted}")
    
    key = input("Enter key for decryption: ")
    ciphertext = input("Enter ciphertext: ")
    
    # Decrypt
    plaintext = decrypt(ciphertext, key)
    print(f"Decrypted: {plaintext}")

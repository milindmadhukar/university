'''
Milind Madhukar
22BCE2747
'''
def mod_inverse_det(d, mod=26):
    d = int(d) % mod
    for i in range(1, mod):
        if (d * i) % mod == 1:
            return i
    return None

def matrix_minor(matrix, row, col):
    return [r[:col] + r[col+1:] for r in (matrix[:row] + matrix[row+1:])]

def matrix_determinant(matrix):
    if len(matrix) == 1:
        return matrix[0][0]
    if len(matrix) == 2:
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
    determinant = 0
    for c in range(len(matrix)):
        determinant += ((-1) ** c) * matrix[0][c] * matrix_determinant(matrix_minor(matrix, 0, c))
    return determinant

def matrix_cofactor(matrix):
    size = len(matrix)
    cofactors = []
    for r in range(size):
        cofactor_row = []
        for c in range(size):
            minor = matrix_minor(matrix, r, c)
            cofactor_row.append(((-1) ** (r + c)) * matrix_determinant(minor))
        cofactors.append(cofactor_row)
    return cofactors

def matrix_transpose(matrix):
    return [[matrix[j][i] for j in range(len(matrix))] for i in range(len(matrix[0]))]

def matrix_mod_inverse(matrix, mod=26):
    determinant = matrix_determinant(matrix) % mod
    determinant_inv = mod_inverse_det(determinant, mod)
    if determinant_inv is None:
        raise ValueError("Matrix is not invertible under mod 26")
    
    cofactor_matrix = matrix_cofactor(matrix)
    adjugate = matrix_transpose(cofactor_matrix)
    return [[(determinant_inv * adjugate[r][c]) % mod for c in range(len(matrix))] for r in range(len(matrix))]

def text_to_numbers(text):
    return [ord(char) - ord('A') for char in text]

def numbers_to_text(numbers):
    return ''.join(chr(num + ord('A')) for num in numbers)

def pad_text(text, n):
    while len(text) % n != 0:
        text += 'X'  # Padding with 'X' to fit matrix size
    return text

def encrypt(plaintext, key_matrix, n):
    plaintext = pad_text(plaintext, n)
    text_numbers = text_to_numbers(plaintext)
    ciphertext_numbers = []
    
    for i in range(0, len(text_numbers), n):
        chunk = text_numbers[i:i + n]
        encrypted_chunk = [(sum(key_matrix[r][c] * chunk[c] for c in range(n)) % 26) for r in range(n)]
        ciphertext_numbers.extend(encrypted_chunk)
    
    return numbers_to_text(ciphertext_numbers)

def decrypt(ciphertext, key_matrix, n):
    key_matrix_inv = matrix_mod_inverse(key_matrix, 26)
    
    print("Inverse Key Matrix:")
    for row in key_matrix_inv:
        print(row)
    
    text_numbers = text_to_numbers(ciphertext)
    plaintext_numbers = []
    
    for i in range(0, len(text_numbers), n):
        chunk = text_numbers[i:i + n]
        decrypted_chunk = [(sum(key_matrix_inv[r][c] * chunk[c] for c in range(n)) % 26) for r in range(n)]
        plaintext_numbers.extend(decrypted_chunk)
    
    return numbers_to_text(plaintext_numbers)

def main():
    n = int(input("Enter the size of the key matrix (n): "))
    print("Enter the key matrix (space-separated values row-wise):")
    key_matrix = []
    for i in range(n):
        row = list(map(int, input().split()))
        key_matrix.append(row)
    
    plaintext = input("Enter the plaintext (uppercase letters only): ").replace(" ", "").upper()
    ciphertext = encrypt(plaintext, key_matrix, n)
    print("Ciphertext:", ciphertext)
    
    decrypted_text = decrypt(ciphertext, key_matrix, n)
    print("Decrypted Text:", decrypted_text)
    
if __name__ == "__main__":
    main()

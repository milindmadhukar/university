txt = "Kill Corona Virus at twelve am tomorrow".replace(" ", "").upper()

rows = 5
columns = 7

# Pad with X
padlen = (rows * columns) - len(txt)
txt += "X" * padlen

vals = [txt[start:start+columns] for start in range(0, len(txt), columns)]
print("Original matrix:", vals)

key = [4, 3, 1, 2, 5, 6, 7]

# Encryption
E = ""
for i in range(1, 8):
    idx = key.index(i)
    for val_idx, val in enumerate(vals):
        E += val[idx]

print("Encrypted text:", E)

# Decryption
# Step 1: Create empty matrix of same size
D_matrix = [[''] * columns for _ in range(rows)]

# Step 2: Fill the matrix column by column according to the key
pos = 0
for i in range(1, 8):
    idx = key.index(i)  # Get original column position
    for row in range(rows):
        D_matrix[row][idx] = E[pos]
        pos += 1

# Step 3: Read the matrix row by row to get decrypted text
D = ""
for row in D_matrix:
    D += ''.join(row)

print("Decrypted text:", D)
print("Decrypted matrix:", D_matrix)
        
    


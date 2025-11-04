m = "neso academy in the best".replace(" ", "").upper()
d = 3
rows = ['']*d

# Encryption
for idx, char in enumerate(m):
    rows[idx % (d)] += char

E = "".join(rows)
print("Encrypted:", E)

# Decryption
quotient = len(E) // d
remainder = len(E) % d

# Calculate length of each row
row_lengths = []
for i in range(d):
    if i < remainder:
        row_lengths.append(quotient + 1)
    else:
        row_lengths.append(quotient)

# Split encrypted text into rows
start = 0
enc_rows = []
for length in row_lengths:
    enc_rows.append(E[start:start + length])
    start += length

# Reconstruct original message
D = ""
for col in range(max(row_lengths)):
    for row in range(d):
        if col < len(enc_rows[row]):
            D += enc_rows[row][col]

print("Decrypted:", D)



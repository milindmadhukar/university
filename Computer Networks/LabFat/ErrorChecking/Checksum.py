# Take data from user as binary
# Split the data into 8 bit words
# Calculate the checksum
# Append the checksum to the data
# Display the data and checksum
# Check if the data is correct or not

WORD_SIZE = 8

def get_words(data: str) -> list:
    words = []
    for i in range(0, len(data), WORD_SIZE):
        words.append(data[i:i+WORD_SIZE].zfill(WORD_SIZE))
    return words

def get_checksum(words: list) -> str:
    checksum = 0
    for word in words:
        checksum += int(word, 2)

    # Cutting the 0b from the binary string
    checksum = bin(checksum)[2:]

    first = checksum[:-WORD_SIZE]
    second = checksum[-WORD_SIZE:]

    checksum = bin(int(first, 2) + int(second, 2))[2:].zfill(WORD_SIZE)

    checksum = ''.join(['1' if bit == '0' else '0' for bit in checksum])

    return checksum

def main():
    data = '10011001111000100010010010000100'
    words = get_words(data)
    checksum = get_checksum(words)
    print(f'Data: {data}')
    print(f'Checksum: {checksum}')

    new_data = data + checksum
    words = get_words(new_data)
    new_checksum = get_checksum(words)
    print(f'New Data: {new_data}')
    print(f'New Checksum: {new_checksum}')

    if new_checksum == '0'*WORD_SIZE:
        print('Data is correct')
    else:
        print('Data is incorrect')


if __name__ == '__main__':
    main()

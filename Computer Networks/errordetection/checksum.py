def add_binary(a, b):
    max_len = max(len(a), len(b))
    a = a.zfill(max_len)
    b = b.zfill(max_len)
    result = ''
    carry = 0
    for i in range(max_len - 1, -1, -1):
        r = carry
        r += 1 if a[i] == '1' else 0
        r += 1 if b[i] == '1' else 0
        result = ('1' if r % 2 == 1 else '0') + result
        carry = 0 if r < 2 else 1
    if carry != 0:
        result = '1' + result
    return result.zfill(max_len)

def compute_checksum(words):
    sum_result = '0' * 8
    for word in words:
        sum_result = add_binary(sum_result, word)
    
    checksum = ''.join('1' if bit == '0' else '0' for bit in sum_result)
    return checksum

def check_data(words, checksum):
    sum_result = '0' * 8
    for word in words:
        sum_result = add_binary(sum_result, word)
    sum_result = add_binary(sum_result, checksum)
    return all(bit == '1' for bit in sum_result)

def main():
    words = []
    for i in range(3):
        word = input(f"Enter binary word {i+1} (8 bits): ")
        words.append(word)
    
    checksum = compute_checksum(words)
    print(f"Computed Checksum: {checksum}")
    
    words_to_send = []
    for i in range(3):
        word = input(f"Enter binary word {i+1} to be sent (8 bits): ")
        words_to_send.append(word)
    
    data_with_checksum = ''.join(words_to_send) + checksum
    print(f"Data with Checksum: {data_with_checksum}")
    
    if check_data(words_to_send, checksum):
        print("Data transmitted correctly.")
    else:
        print("Data transmission error detected.")

if __name__ == "__main__":
    main()



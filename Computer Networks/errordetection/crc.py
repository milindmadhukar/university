def xor_operation(data, divisor):
    return ''.join('0' if d == p else '1' for d, p in zip(data, divisor))

def generate_crc(word, divisor):
    padded_word = word + '0' * (len(divisor) - 1)
    temp = padded_word[:len(divisor)]
    
    for i in range(len(padded_word) - len(divisor) + 1):
        if temp[0] == '1':
            temp = xor_operation(temp, divisor)
        if i + len(divisor) < len(padded_word):
            temp = temp[1:] + padded_word[i + len(divisor)]
    
    return temp[-(len(divisor) - 1):]

def check_crc(data, divisor):
    temp = data[:len(divisor)]
    
    for i in range(len(data) - len(divisor) + 1):
        if temp[0] == '1':
            temp = xor_operation(temp, divisor)
        if i + len(divisor) < len(data):
            temp = temp[1:] + data[i + len(divisor)]
    
    return all(bit == '0' for bit in temp)

def main():
    word = input("Enter the binary word: ")
    divisor = input("Enter the binary divisor: ")
    
    crc = generate_crc(word, divisor)
    print(f"Generated CRC: {crc}")
    
    received_data = input("Enter the binary received data: ")
    transmitted_data = received_data + crc
    print(f"Transmitted Data: {transmitted_data}")
    
    if check_crc(transmitted_data, divisor):
        print("Data transmitted correctly.")
    else:
        print("Data transmission error detected.")

if __name__ == "__main__":
    main()

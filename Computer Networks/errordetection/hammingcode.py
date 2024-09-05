import math

def calculate_redundant_bits(m):
    for i in range(m):
        if(2**i >= m + i + 1):
            return i

def position_redundant_bits(data, r):
    j = 0
    k = 1
    m = len(data)
    res = ''

    for i in range(1, m + r + 1):
        if(i == 2**j):
            res = res + '0'
            j += 1
        else:
            res = res + data[k-1]
            k += 1

    return res

def calculate_parity_bits(arr, r):
    n = len(arr)

    for i in range(r):
        val = 0
        for j in range(1, n + 1):
            if(j & (2**i) == (2**i)):
                val = val ^ int(arr[j-1])

        arr = arr[:2**i-1] + str(val) + arr[2**i:]
    return arr

def detect_error(arr):
    n = len(arr)
    res = 0

    for i in range(n):
        if(arr[i] == '1'):
            res = res ^ (i + 1)

    return res

def hamming_code(data):
    m = len(data)
    r = calculate_redundant_bits(m)
    
    arr = position_redundant_bits(data, r)
    
    arr = calculate_parity_bits(arr, r)
    
    return arr

def main():
    data = input("Enter the data bits: ")
    print(f"Data bits are: {data}")

    code = hamming_code(data)
    print(f"The generated Hamming code is: {code}")

    received = list(code)
    error_position = int(input("Enter the position to introduce error (0 for no error): "))
    if error_position > 0:
        received[error_position - 1] = '0' if received[error_position - 1] == '1' else '1'
    received = ''.join(received)
    print(f"Received code is: {received}")

    correction = detect_error(received)
    if(correction == 0):
        print("There is no error in the received code.")
    else:
        print(f"The position of error is {correction}.")
        received = list(received)
        received[correction - 1] = '0' if received[correction - 1] == '1' else '1'
        print(f"The corrected code is: {''.join(received)}")

if __name__ == "__main__":
    main()

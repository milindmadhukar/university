import math

# For a given length of data, gives number of parity bits needed.
def calculate_redundant_bits(m):
    for i in range(m):
        if(2**i >= m + i + 1):
            return i

# For a given data. Positions the redundant bits and initializes them to be 0
def position_redundant_bits(data, r):
    j = 0
    k = 1
    m = len(data)
    res = ''

    for i in range(1, m + r + 1):
        if(i == 2**j):
            res += '0'
            j += 1
        else:
            res += data[k-1]
            k += 1

    return res

def get_even_parity_bit(bits):
    count = list(bits).count(1)
    return (count & 1)


def calculate_redundant_bits(data):
    i = 0
    for idx, bit in enumerate(data):
        if idx+1 == 2**i:
            i += 1
            concerned_bits = []
            for loc, bit in enumerate(data):
                if(bit & i and loc + 1 != i):
                    concerned_bits.append(data[idx])
            data[idx] = get_even_parity_bit(concerned_bits)
        
    return data  



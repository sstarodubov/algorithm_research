def count_bits(num):
    result = 0
    while num:
        last_bit = num & 1
        num >>= 1
        result += last_bit
    return result


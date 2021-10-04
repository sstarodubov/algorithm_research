def count_bits(num):
    result = 0
    while num:
        last_bit = num & 1
        num >>= 1
        result += last_bit
    return result


def find_parity(num) -> int:
    last_bit = num & 1
    return last_bit


def find_num_of_1s_bits(num) -> int:
    ans = 0
    while num:
        last_bit = num & 1
        if last_bit == 1:
            ans += 1
        num >>= 1
    return ans


def find_val_of_1_bit(num):
    ans = 0
    while num:
        num = (num - 1) & num
        ans += 1
    return ans


def swap_bits(n, i, j):
    bit_i = (n >> i) & 1
    bit_j = (n >> j) & 1
    if bit_j != bit_i:
        bit_mask = (1 << i) | (1 << j)
        return n ^ bit_mask
    return n


# cpu O(1)
def set_bit(num, bit, idx):
    idx_bit = (num >> idx) & 1
    if idx_bit == bit:
        return num
    bit_mask = 1 << idx
    return num ^ bit_mask


# cpu O(n)
def reverse_bit(n):
    tmp, ans, len = n, n, 0
    while tmp:
        tmp >>= 1
        len += 1
    tmp, idx = n, len - 1
    while tmp:
        last_bit = tmp & 1
        ans = set_bit(ans, last_bit, idx)
        tmp >>= 1
        idx -= 1
    return ans
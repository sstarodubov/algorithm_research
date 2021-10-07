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
def set_by_idx(num, bit, idx):
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
        ans = set_by_idx(ans, last_bit, idx)
        tmp >>= 1
        idx -= 1
    return ans


# cpu O(n^2)
def find_closest_with_same_weight(n: int) -> int:
    def define_weight(d):
        w = 0
        while d:
            d = d & (d - 1)
            w += 1
        return w

    nw = define_weight(n)
    for i in range(n - 1, 0, -1):
        cur_weight = define_weight(i)
        if cur_weight == nw:
            return i
    return n


# cpu O (n)
def find_closest_with_same_weight2(n: int) -> int:
    long_bits = 64
    for row in range(long_bits):
        if (n >> row) & 1 != (n >> row + 1) & 1:
            bit_mask = (1 << row) | (1 << row + 1)
            return n ^ bit_mask
    return -1


def sum(x, y):
    ans, xtmp, ytmp, idx, carryin = 0, x, y, 1, 0
    while xtmp or ytmp:
        xidx = x & idx
        yidx = y & idx
        carryout = (xidx & yidx) | (xidx & carryin) | (yidx & carryin)
        ans |= xidx ^ yidx ^ carryin
        xtmp >>= 1
        ytmp >>= 1
        carryin = carryout << 1
        idx = idx << 1
    return ans | carryin


def multiply(x, y):
    ans = 0
    while x:
        if x & 1:
            ans = sum(ans, y)
        x, y = x >> 1, y << 1
    return ans


def reverse_number(n):
    remaining, ans = n, 0
    while remaining:
        ans = ans * 10 + remaining % 10
        remaining //= 10
    return ans


def divide(x, y):
    ans = 0
    while x:
        ans += 1
        x = x - y

    return ans

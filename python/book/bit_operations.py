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


def add(x, y):
    run_sum, idx, carrin, tmpx, tmpy = 0, 1, 0, x, y
    while tmpx or tmpy:
        xidx, yidx = x & idx, y & idx
        carryout = (xidx & yidx) | (xidx & carrin) | (yidx & carrin)
        run_sum |= xidx ^ yidx ^ carrin
        tmpy, tmpx, carrin, idx = tmpy >> 1, tmpx >> 1, carryout << 1, idx << 1
    return run_sum | carrin


def multiply(x, y):
    running_sum = 0
    while x:
        if x & 1 == 1:
            running_sum = add(running_sum, y)
        x, y = x >> 1, y << 1
    return running_sum

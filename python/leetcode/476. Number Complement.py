import math


class Solution:
    def findComplement(self, num: int) -> int:
        if num == 0 :
            return 1

        def first_bit_idx(n):
            return math.floor(math.log(n | 0) / math.log(2)) + 1

        c, bit_idx = num, int(first_bit_idx(num))

        mask = 1
        for idx in range(bit_idx):
            c = mask ^ c
            mask = mask << 1
        return c


assert 2 == Solution().findComplement(5)
assert 1 == Solution().findComplement(0)

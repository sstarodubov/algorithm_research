class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        while n:
            last_bit = n & 1
            if last_bit:
                ans += 1
            n = n >> 1

        return ans



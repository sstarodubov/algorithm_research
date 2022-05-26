class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        for i in range(32):
            bit = n & 1
            if bit: ans += 1
            n = n >> 1
        return ans

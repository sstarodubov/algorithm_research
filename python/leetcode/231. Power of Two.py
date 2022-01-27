class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        n = n - 1 & n
        return n == 0

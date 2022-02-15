class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        cur, prev = n & 1, (n & 1) ^ 1
        n = n >> 1
        while n:
            if cur == prev:
                return False
            prev = cur
            cur = n & 1
            n = n >> 1

        return cur != prev


assert not Solution().hasAlternatingBits(3)
assert Solution().hasAlternatingBits(5)
assert not Solution().hasAlternatingBits(7)
assert not Solution().hasAlternatingBits(11)

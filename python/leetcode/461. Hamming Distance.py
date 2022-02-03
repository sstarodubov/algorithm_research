class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        ans = 0
        for i in range(32, 0, -1):
            bx = x & 1
            by = y & 1

            if by != bx:
                ans += 1

            x = x >> 1
            y = y >> 1

        return ans


assert 2 == Solution().hammingDistance(4, 2)
assert 1 == Solution().hammingDistance(x=3, y=1)
assert 2 == Solution().hammingDistance(x=1, y=4)

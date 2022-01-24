class Solution:
    def climbStairs(self, n: int) -> int:
        prev = 0
        cur = 1
        ans = 0
        while n > 0:
            ans = cur + prev
            prev = cur
            cur = ans
            n -= 1
        return ans


assert Solution().climbStairs(3) == 3
assert Solution().climbStairs(2) == 2

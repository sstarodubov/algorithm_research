"""
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
"""


class Solution:

    # CPU O(n) and RAM O(1)
    def climbStairs(self, n: int) -> int:
        if n == 1: return 1
        x, y = 1, 2
        for i in range(3, n + 1):
            x, y = y, x + y
        return y


s = Solution()

assert s.climbStairs(2) == 2, 1
assert s.climbStairs(3) == 3, 2

print("tests passed")

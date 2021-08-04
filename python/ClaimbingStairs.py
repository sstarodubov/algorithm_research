"""
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
"""


class Solution:

    # CPU O(n) and RAM O(n)
    def climbStairs(self, n: int) -> int:
        arr = [0 for _ in range(n)]
        if len(arr) == 0:
            return 0
        if len(arr) == 1:
            return 1
        if len(arr) == 2:
            return 2
        arr[0] = 1
        arr[1] = 2
        for i in range(2, len(arr)):
            arr[i] = arr[i - 1] + arr[i - 2]
        return arr[len(arr) - 1]


s = Solution()

assert s.climbStairs(2) == 2, 1
assert s.climbStairs(3) == 3, 2

print("tests passed")

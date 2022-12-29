class Solution:
    def climbStairs(self, n: int) -> int:
        p, k = 0, 1
        t: int
        while n:
            t = k
            k += p
            p = t
            n -= 1

        return k

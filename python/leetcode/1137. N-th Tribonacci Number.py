class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        p, pp, ppp, counter, cur = 1, 1, 0, 0, 1

        while counter < n - 2:
            cur = p + pp + ppp
            ppp = pp
            pp = p
            p = cur
            counter += 1
        return cur


assert Solution().tribonacci(25) == 1389537
assert Solution().tribonacci(4) == 4

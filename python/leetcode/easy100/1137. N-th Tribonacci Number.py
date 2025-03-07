class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1

        if n == 2:
            return 1
        k = 2
        ppp, pp, p = 0, 1, 1

        while k < n:
            nxt = p + pp + ppp

            ppp = pp
            pp = p
            p = nxt
            k += 1

        return p




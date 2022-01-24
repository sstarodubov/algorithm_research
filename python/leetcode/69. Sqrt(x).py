class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        l, r = 1, (x // 2) + 1
        while l < r:
            m = (l + r) // 2
            if m * m == x:
                return m
            elif m * m < x:
                l = m
            elif m * m > x:
                r = m
            if r - 1 == l:
                break
        if r * r == x:
            return r
        return l


assert Solution().mySqrt(5) == 2
assert Solution().mySqrt(4) == 2
assert Solution().mySqrt(59) == 7

from typing import List


class Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:
        def has_zero(t):
            if not t:
                return True
            while t:
                if t % 10 == 0:
                    return True
                t = t // 10
            return False

        l, r = 1, n - 1

        while l < r:
            t = l + r
            if t == n:
                if not has_zero(l) and not has_zero(r):
                    return [l, r]
                else:
                    r -= 1
            elif t > n:
                r -= 1
            else:
                l += 1

        return [l, r]


assert [1, 1] == Solution().getNoZeroIntegers(2)
assert [2, 9] == Solution().getNoZeroIntegers(11)

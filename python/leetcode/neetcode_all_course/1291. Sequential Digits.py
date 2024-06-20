from typing import List


class Solution:

    def append_d(self, n, d):
        return (n * 10) + d

    def size(self, n):
        s = 0
        if n == 0:
            return 1
        while n:
            n = n // 10
            s += 1
        return s

    def sequentialDigits(self, low: int, high: int) -> List[int]:
        d = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        ret = []

        ls = self.size(low)
        l, r = 0, ls
        while True:
            cur = 0
            for i in range(l, r):
                if r > len(d):
                    return ret
                cur = self.append_d(cur, d[i])

            if cur > high:
                return ret

            if cur >= low:
                ret.append(cur)

            if r >= len(d):
                l = 0
                ls += 1
                r = ls
            else:
                l += 1
                r += 1

print(Solution().sequentialDigits(low=10, high=1000000000))

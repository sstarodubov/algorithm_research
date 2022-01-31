def guess(num):
    if num == 6:
        return 0
    if 6 > num:
        return 1
    if 6 < num:
        return -1


class Solution:
    def guessNumber(self, n: int) -> int:
        l, r = 0, n
        while l < r and r - l != 1:
            m = (l + r) // 2
            a = guess(m)
            if a == 0:
                return m
            if a == 1:
                l = m + 1
            else:
                r = m - 1

        if guess(l) == 0:
            return l
        if guess(r) == 0:
            return r
        return -1


assert 6 == Solution().guessNumber(10)

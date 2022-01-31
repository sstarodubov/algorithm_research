class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        l, r = 1, num // 2 + 1
        while l < r and r - l != 1:
            m = (l + r) // 2
            if m ** 2 == num:
                return True
            elif m ** 2 > num:
                r = m - 1
            elif m ** 2 < num:
                l = m + 1

        if l ** 2 == num:
            return True
        if r ** 2 == num:
            return True

        return False


assert Solution().isPerfectSquare(16)
assert Solution().isPerfectSquare(9)
assert not Solution().isPerfectSquare(3)

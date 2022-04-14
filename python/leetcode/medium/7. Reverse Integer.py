class Solution:
    def reverse(self, x: int) -> int:
        sign = 1 if x >= 0 else -1
        x, ans = abs(x), 0
        while x:
            last = x % 10
            ans = ans * 10 + last
            x //= 10

        if (-2 ** 31) <= ans <= ((2 ** 31) - 1):
            return sign * ans
        return 0


assert 321 == Solution().reverse(123)

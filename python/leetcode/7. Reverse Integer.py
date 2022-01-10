class Solution:

    # time O(n), space O(1)
    def reverse(self, x: int) -> int:
        flag = False if x >= 0 else True
        ans = 0
        x = abs(x)

        while x:
            last_digit = x % 10
            ans = ans * 10 + last_digit
            x = x // 10

        if not flag:
            if ans >= pow(2, 31) - 1:
                return 0
            return ans
        if ans >= pow(2, 31):
            return 0
        return -ans
assert Solution().reverse(-1563847412) == 0
assert Solution().reverse(120) == 21
assert Solution().reverse(123) == 321
assert Solution().reverse(-123) == -321
print("tests passed")

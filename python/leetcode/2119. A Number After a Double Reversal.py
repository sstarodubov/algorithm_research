class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        def reverse(x: int):
            ans = 0
            while x:
                last_digit = x % 10
                ans = ans * 10 + last_digit
                x = x // 10
            return ans

        return reverse(reverse(num)) == num


assert Solution().isSameAfterReversals(526)

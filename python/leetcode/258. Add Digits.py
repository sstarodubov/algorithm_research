class Solution:
    def addDigits(self, num: int) -> int:
        def sum_digits(n):
            ans = 0
            while n:
                last = n % 10
                ans = ans + last
                n //= 10
            return ans

        def is_one_len_digit(n):
            return n // 10 == 0

        while True:
            num = sum_digits(num)
            if is_one_len_digit(num):
                return num

        return -1


print(Solution().addDigits(38))

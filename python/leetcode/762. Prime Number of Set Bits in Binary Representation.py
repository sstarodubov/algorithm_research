class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        def is_prime(n: int) -> bool:
            if n == 0 or n == 1:
                return False
            for i in range(2, n):
                if n % i == 0:
                    return False
            return True

        def count_bits(n: int) -> int:
            ans = 0
            while n:
                b = n & 1
                if b:
                    ans += 1
                n = n >> 1
            return ans

        ans = 0
        for i in range(left, right + 1):
            bits = count_bits(i)
            if is_prime(bits):
                ans += 1
        return ans

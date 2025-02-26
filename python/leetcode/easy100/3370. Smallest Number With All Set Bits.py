class Solution:
    def only_bits(self, n):
        for i in range(32):
           if n & 1 == 1:
                n = n >> 1
           else:
               n = n >> 1
               break

        for i in range(32):
            if n & 1 == 1:
                return False
            else:
                n = n >> 1
        return True


    def smallestNumber(self, n: int) -> int:

        for i in range(n, 9999999999999999999):
            if self.only_bits(i):
                return i


print(Solution().smallestNumber(12))
from typing import List


class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        def is_self(n):
            init = n

            while n:
                last = n % 10
                if last == 0:
                    return False
                if init % last != 0:
                    return False
                n = n // 10

            return True
        ans = []
        for i in range(left, right + 1):
            if is_self(i):
                ans.append(i)

        return ans

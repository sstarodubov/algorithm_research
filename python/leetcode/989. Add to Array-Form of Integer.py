from typing import List


class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        def to_int(arr: List[int]):
            ans = 0
            p = len(num) - 1
            for i in range(len(num)):
                ans += num[i] * (10 ** p)
                p -= 1
            return ans

        def to_arr(n: int):
            ans = []
            while n:
                last = n % 10
                ans.append(last)
                n //= 10
            ans.reverse()
            return ans

        a = to_int(num)
        ans = to_arr(a + k)

        return ans


assert Solution().addToArrayForm(num=[1, 2, 0, 0], k=34) == [1, 2, 3, 4]

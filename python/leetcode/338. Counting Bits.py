from typing import List


class Solution:
    def countBits(self, n: int) -> List[int]:
        def bits(num):
            ans = 0
            while num:
                num = (num - 1) & num
                ans += 1
            return ans

        ans = []
        for i in range(n + 1):
            ans.append(bits(i))
        return ans

assert [0,1,1,2,1,2] == Solution().countBits(5)
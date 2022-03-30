from typing import List


class Solution:
    def sumZero(self, n: int) -> List[int]:
        ans = []
        l = n if (n & 1) == 0 else n - 1
        if (n & 1) == 1:
            ans.append(0)
        if n == 1:
            return ans
        for i in range(1, (l // 2) + 1):
            ans.append(i)
            ans.append(-i)
        return ans

Solution().sumZero(6)
Solution().sumZero(5)

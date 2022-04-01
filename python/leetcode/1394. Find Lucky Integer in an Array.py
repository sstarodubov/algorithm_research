from collections import defaultdict
from typing import List


class Solution:
    def findLucky(self, arr: List[int]) -> int:
        ans = -1
        m = defaultdict(lambda: 0)
        for n in arr:
            m[n] += 1
        for k in m:
            if m[k] == k:
                ans = max(ans, k)
        return ans


assert 2 == Solution().findLucky([2, 2, 3, 4])

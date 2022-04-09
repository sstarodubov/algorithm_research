from collections import defaultdict
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hm = defaultdict(lambda: 0)
        for n in nums:
            hm[n] += 1

        xs = []
        for key in hm:
            xs.append((hm[key], key))
        xs.sort(key=lambda x: x[0], reverse=True)

        ans = []
        for i in range(k):
            ans.append(xs[i][1])

        return ans


assert Solution().topKFrequent(nums=[1, 1, 1, 2, 2, 3], k=2) == [1, 2]

from collections import defaultdict
from typing import List


class Solution:

    def findLHS(self, nums: List[int]) -> int:
        ans = 0
        d = defaultdict(lambda: 0)
        for n in nums:
            d[n] += 1
        nums.sort()
        for i in range(1, len(nums)):
            if nums[i - 1] + 1 == nums[i]:
                ans = max(ans, d[nums[i - 1]] + d[nums[i]])
        return ans


assert 5 == Solution().findLHS([1, 3, 2, 2, 5, 2, 3, 7])
assert 2 == Solution().findLHS([1, 2, 3, 4])

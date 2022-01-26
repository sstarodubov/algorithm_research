from collections import defaultdict
from typing import List


class Solution:

    # time O( n ) , space O(n)
    def majorityElement(self, nums: List[int]) -> int:
        d = defaultdict(lambda: 0)
        for n in nums:
            d[n] += 1
            if d[n] > len(nums) // 2:
                return n
        return -1


assert Solution().majorityElement([2, 2, 1, 1, 1, 2, 2]) == 2

from collections import defaultdict
from typing import List


class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        t = len(nums) // 2
        d = defaultdict(lambda: 0)
        for n in nums:
            d[n] += 1
            if d[n] == t:
                return n
        return -1

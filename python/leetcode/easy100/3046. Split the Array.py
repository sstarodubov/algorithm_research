from typing import List


class Solution:
    def isPossibleToSplit(self, nums: List[int]) -> bool:
        m = {}
        for n in nums:
            cur = m.get(n, 0)
            cur = cur + 1
            m[n] = cur
            if cur >= 3:
                return False
        return True
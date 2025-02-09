from typing import List


class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        ml = float("inf")
        for i in range(start , len(nums)):
            if nums[i] == target:
                ml = min(ml, abs(i -start))

        mr = float('inf')
        for i in range(start - 1, -1, -1):
            if nums[i] == target:
                mr = min(mr, abs(i - start))

        return min(mr, ml)


Solution().getMinDistance([1, 2], 0 , 1)
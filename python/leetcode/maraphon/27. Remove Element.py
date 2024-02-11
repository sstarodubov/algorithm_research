from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        w = 0
        for r in range(len(nums)):
            if nums[r] != val:
                nums[w] = nums[r]
                w += 1
        return w + 1

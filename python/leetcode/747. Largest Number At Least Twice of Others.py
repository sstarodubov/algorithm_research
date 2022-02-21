from typing import List


class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        largest,idx = -1, -1
        for i in range(len(nums)):
            if nums[i] > largest:
                largest = nums[i]
                idx = i
        for i in range(len(nums)):
            if nums[i] == largest or nums[i] == 0:
                continue
            if (largest / nums[i]) < 2:
                return -1
        return idx



